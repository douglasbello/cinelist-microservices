package com.cinelist.ms.catalog.controllers.register;

import com.cinelist.ms.catalog.database.models.Movie;
import com.cinelist.ms.catalog.dtos.movies.MovieRequest;
import org.springframework.http.ResponseEntity;

public interface MovieRegisterController {
    ResponseEntity<Movie> register(MovieRequest request);
}