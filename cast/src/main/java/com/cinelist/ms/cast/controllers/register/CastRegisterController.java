package com.cinelist.ms.cast.controllers.register;

import com.cinelist.ms.cast.database.models.Cast;
import com.cinelist.ms.cast.dtos.cast.CastRequest;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;

@Validated
@Tag(name = "Cast Register Controller")
public interface CastRegisterController {
    @Operation(summary = "Register an cast.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Cast registered successfully."),
            @ApiResponse(responseCode = "400", description = "Wrong data type provided in specific field.")
    })
    ResponseEntity<Cast> register(@Valid CastRequest request);
}