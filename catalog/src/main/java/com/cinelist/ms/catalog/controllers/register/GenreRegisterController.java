package com.cinelist.ms.catalog.controllers.register;

import com.cinelist.ms.catalog.database.models.Genre;
import com.cinelist.ms.catalog.dtos.genres.GenreRequest;
import org.springframework.http.ResponseEntity;

public interface GenreRegisterController {
    ResponseEntity<Genre> register(GenreRequest request);
}