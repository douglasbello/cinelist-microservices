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
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/movies")
public class MovieRegisterControllerImpl implements MovieRegisterController {
    private final MovieRegisterService movieRegisterService;

    public MovieRegisterControllerImpl(MovieRegisterService movieRegisterService) {
        this.movieRegisterService = movieRegisterService;
    }

    @PostMapping
    public ResponseEntity<Movie> register(@RequestBody MovieRequest request) {
        Movie created = movieRegisterService.register(request);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{identifier}").buildAndExpand(created.getIdentifier()).toUri();

        return ResponseEntity.created(uri).body(created);
    }

    // for development purposes only
    @PostMapping("/all")
    public ResponseEntity<List<Movie>> registerAll(@RequestBody List<MovieRequest> movieRequests) {
        List<Movie> response = movieRequests.stream().map(req -> movieRegisterService.register(req)).toList();

        return ResponseEntity.ok().body(response);
    }
}