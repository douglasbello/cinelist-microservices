package com.cinelist.ms.cast.controllers.register;

import com.cinelist.ms.cast.database.models.Occupation;
import com.cinelist.ms.cast.dtos.occupations.OccupationRequest;
import org.springframework.http.ResponseEntity;

public interface OccupationRegisterController {
    ResponseEntity<Occupation> register(OccupationRequest request);
}