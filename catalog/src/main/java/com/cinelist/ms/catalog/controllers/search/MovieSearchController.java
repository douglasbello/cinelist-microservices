package com.cinelist.ms.catalog.controllers.search;

import com.cinelist.ms.catalog.database.models.Movie;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

import java.util.UUID;

public interface MovieSearchController {
    ResponseEntity<Page<Movie>> findAll(Pageable pageable);
    ResponseEntity<Movie> findByIdentifier(UUID identifier);
    ResponseEntity<Page<Movie>> findAllByGenreIdentifier(UUID identifier, Pageable pageable);
    ResponseEntity<Page<Movie>> findAllByPlatformIdentifier(UUID platformIdentifier, Pageable pageable);
    ResponseEntity<Page<Movie>> findAllByLanguageIdentifier(UUID languageIdentifier, Pageable pageable);
    ResponseEntity<Page<Movie>> findAllByCertificateIdentifier(UUID certificateIdentifier, Pageable pageable);
    ResponseEntity<Page<Movie>> findAllByTitle(String title, Pageable pageable);
    ResponseEntity<Page<Movie>> upcoming(Pageable pageable);
    ResponseEntity<Page<Movie>> latest(Pageable pageable);
}