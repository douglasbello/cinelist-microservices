package com.cinelist.ms.catalog.controllers.search;

import com.cinelist.ms.catalog.database.models.Movie;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;

public interface MovieSearchController {
    ResponseEntity<Page<Movie>> findAll();
}