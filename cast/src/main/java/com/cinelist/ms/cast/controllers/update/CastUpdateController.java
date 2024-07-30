package com.cinelist.ms.cast.controllers.update;

import com.cinelist.ms.cast.dtos.castmovie.CastMovieRequest;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;

import java.util.UUID;

@Tag(name = "Cast Update Controller")
public interface CastUpdateController {
    @Operation(summary = "Receives CastMovieRequest and saves Cast - Movie relation in CastMovie table.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Operation successful, no content."),
            @ApiResponse(responseCode = "400", description = "Wrong data type provided in specific field."),
            @ApiResponse(responseCode = "404", description = "Cast or Movie not found.")
    })
    ResponseEntity<Void> addCastToMovie(CastMovieRequest request);

    @Operation(summary = "Receives Cast and Occupation identifier, then saves Cast - Occupation relation in CastOccupation table.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Operation successful, no content."),
            @ApiResponse(responseCode = "400", description = "Wrong data type provided for UUID identifier."),
            @ApiResponse(responseCode = "404", description = "Cast or Occupation not found.")
    })
    ResponseEntity<Void> addOccupationToCast(UUID castIdentifier, UUID occupationIdentifier);
}