package com.cinelist.ms.catalog.controllers.update;

import com.cinelist.ms.catalog.dtos.movies.MovieRequest;
import org.springframework.http.ResponseEntity;

import java.util.UUID;

public interface MovieUpdateController {
    ResponseEntity<Void> addGenreToMovie(UUID genreIdentifier, UUID movieIdentifier);
    ResponseEntity<Void> addPlatformToMovie(UUID platformIdentifier, UUID movieIdentifier);
    ResponseEntity<Void> updateInfos(UUID movieIdentifier, MovieRequest request);
}