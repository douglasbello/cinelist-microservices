package com.cinelist.ms.catalog.controllers.search;

import com.cinelist.ms.catalog.database.models.Genre;
import org.springframework.http.ResponseEntity;

public interface GenreSearchController {
    ResponseEntity<Genre> findByName(String name);
}