package com.cinelist.ms.cast.controllers.register;

import com.cinelist.ms.cast.database.models.Cast;
import com.cinelist.ms.cast.dtos.cast.CastRequest;
import org.springframework.http.ResponseEntity;

public interface CastRegisterController {
    ResponseEntity<Cast> register(CastRequest request);
}