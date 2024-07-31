package com.cinelist.ms.cast.controllers.register;

import com.cinelist.ms.cast.database.models.Occupation;
import com.cinelist.ms.cast.dtos.occupations.OccupationRequest;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;

@Validated
@Tag(name = "Occupation Register Controller")
public interface OccupationRegisterController {
    @Operation(summary = "Register a occupation.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Occupation created successfully."),
            @ApiResponse(responseCode = "400", description = "Wrong data type provided in specific field.")
    })
    ResponseEntity<Occupation> register(@Valid OccupationRequest request);
}