package com.cinelist.ms.cast.controllers.search;

import com.cinelist.ms.cast.database.models.Cast;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

import java.util.UUID;

@Tag(name = "Cast Search Controller")
public interface CastSearchController {
    @Operation(summary = "Find cast by identifier.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Cast found and returned successfully."),
            @ApiResponse(responseCode = "400", description = "Wrong data type provided for UUID identifier."),
            @ApiResponse(responseCode = "404", description = "Cast not found with identifier.")
    })
    ResponseEntity<Cast> findByIdentifier(UUID identifier);

    @Operation(summary = "Find page of cast by name. (may be empty)")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Returns page cast by specified name. (may be empty)")
    })
    ResponseEntity<Page<Cast>> findByName(String name, Pageable pageable);
}