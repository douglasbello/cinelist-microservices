package com.cinelist.ms.catalog.controllers.register;

import com.cinelist.ms.catalog.database.models.Movie;
import com.cinelist.ms.catalog.dtos.platforms.PlatformRequest;
import org.springframework.http.ResponseEntity;

public interface PlatformRegisterController {
    ResponseEntity<Movie> register(PlatformRequest request);
}