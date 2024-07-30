package com.cinelist.ms.cast.controllers.search;

import com.cinelist.ms.cast.database.models.Occupation;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.UUID;

@Tag(name = "Occupation Search Controller")
public interface OccupationSearchController {
    @Operation(summary = "Find occupation by identifier.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Occupation found and returned successfully."),
            @ApiResponse(responseCode = "400", description = "Wrong data provided for UUID identifier."),
            @ApiResponse(responseCode = "404", description = "Occupation not found with given identifier.")
    })
    ResponseEntity<Occupation> findByIdentifier(UUID identifier);

    @Operation(summary = "Find all occupations.")
    @ApiResponses(
            @ApiResponse(responseCode = "200", description = "Returned all occupations successfully.")
    )
    ResponseEntity<List<Occupation>> findAll();
}