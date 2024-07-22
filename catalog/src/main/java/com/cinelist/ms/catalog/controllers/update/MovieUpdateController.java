package com.cinelist.ms.catalog.controllers.update;

import org.springframework.http.ResponseEntity;

import java.util.UUID;

public interface MovieUpdateController {
    ResponseEntity<Void> addGenreToMovie(UUID genreIdentifier, UUID movieIdentifier);
    ResponseEntity<Void> addPlatformToMovie(UUID platformIdentifier, UUID movieIdentifier);
    ResponseEntity<Void> addLanguageToMovie(UUID languageIdentifier, UUID movieIdentifier);
}