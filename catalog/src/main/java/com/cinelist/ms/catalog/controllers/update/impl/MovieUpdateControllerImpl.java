package com.cinelist.ms.catalog.controllers.update.impl;

import com.cinelist.ms.catalog.controllers.update.MovieUpdateController;
import com.cinelist.ms.catalog.dtos.movies.MovieRequest;
import com.cinelist.ms.catalog.services.update.MovieUpdateService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/movies")
public class MovieUpdateControllerImpl implements MovieUpdateController {
    private final MovieUpdateService movieUpdateService;

    public MovieUpdateControllerImpl(MovieUpdateService movieUpdateService) {
        this.movieUpdateService = movieUpdateService;
    }

    @PutMapping("/{movieIdentifier}/addgenre/{genreIdentifier}")
    public ResponseEntity<Void> addGenreToMovie(@PathVariable UUID genreIdentifier, @PathVariable UUID movieIdentifier) {
        movieUpdateService.addGenreToMovie(genreIdentifier, movieIdentifier);

        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{movieIdentifier}/addplatform/{platformIdentifier}")
    public ResponseEntity<Void> addPlatformToMovie(@PathVariable UUID platformIdentifier, @PathVariable UUID movieIdentifier) {
        movieUpdateService.addPlatformToMovie(platformIdentifier, movieIdentifier);

        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{movieIdentifier}")
    public ResponseEntity<Void> updateInfos(@PathVariable UUID movieIdentifier, @RequestBody MovieRequest request) {
        movieUpdateService.updateInfo(movieIdentifier, request);

        return ResponseEntity.noContent().build();
    }
}