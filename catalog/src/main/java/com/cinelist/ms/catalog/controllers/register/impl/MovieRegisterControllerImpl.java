package com.cinelist.ms.catalog.controllers.register.impl;

import com.cinelist.ms.catalog.controllers.register.MovieRegisterController;
import com.cinelist.ms.catalog.database.models.Movie;
import com.cinelist.ms.catalog.dtos.movies.MovieRequest;
import com.cinelist.ms.catalog.services.register.MovieRegisterService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/movies")
public class MovieRegisterControllerImpl implements MovieRegisterController {
    private final MovieRegisterService movieRegisterService;

    public MovieRegisterControllerImpl(MovieRegisterService movieRegisterService) {
        this.movieRegisterService = movieRegisterService;
    }

    @PostMapping
    public ResponseEntity<Movie> register(@RequestBody MovieRequest request) {
        return ResponseEntity.ok().body(movieRegisterService.register(request));
    }
}