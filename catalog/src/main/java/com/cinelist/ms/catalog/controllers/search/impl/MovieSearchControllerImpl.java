package com.cinelist.ms.catalog.controllers.search.impl;

import com.cinelist.ms.catalog.controllers.search.MovieSearchController;
import com.cinelist.ms.catalog.database.models.Movie;
import com.cinelist.ms.catalog.services.search.MovieSearchService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/movies")
public class MovieSearchControllerImpl implements MovieSearchController {
    private final MovieSearchService movieSearchService;

    public MovieSearchControllerImpl(MovieSearchService movieSearchService) {
        this.movieSearchService = movieSearchService;
    }

    @GetMapping
    public ResponseEntity<Page<Movie>> findAll(@PageableDefault(size = 12) Pageable pageable) {
        return ResponseEntity.ok().body(movieSearchService.findAll(pageable));
    }

    @GetMapping("/all/{identifiers}")
    public ResponseEntity<Page<Movie>> findAllByIdentifier(@PathVariable List<UUID> identifiers, @PageableDefault(size = 12) Pageable pageable) {
        return ResponseEntity.ok().body(movieSearchService.findAllByIdentifier(identifiers, pageable));
    }

    @GetMapping("/{identifier}")
    public ResponseEntity<Movie> findByIdentifier(@PathVariable UUID identifier) {
        return ResponseEntity.ok().body(movieSearchService.details(identifier));
    }

    @GetMapping("/genres/{identifier}")
    public ResponseEntity<Page<Movie>> findAllByGenreIdentifier(@PathVariable UUID identifier, @PageableDefault(size = 12) Pageable pageable) {
        return ResponseEntity.ok().body(movieSearchService.findAllByGenreIdentifier(identifier, pageable));
    }

    @GetMapping("/platforms/{platformIdentifier}")
    public ResponseEntity<Page<Movie>> findAllByPlatformIdentifier(@PathVariable UUID platformIdentifier, @PageableDefault(size = 12) Pageable pageable) {
        return ResponseEntity.ok().body(movieSearchService.findAllByPlatformIdentifier(platformIdentifier, pageable));
    }

    @GetMapping("/languages/{languageIdentifier}")
    public ResponseEntity<Page<Movie>> findAllByLanguageIdentifier(@PathVariable UUID languageIdentifier, @PageableDefault(size = 12) Pageable pageable) {
        return ResponseEntity.ok().body(movieSearchService.findAllByLanguageIdentifier(languageIdentifier, pageable));
    }

    @GetMapping("/certificates/{certificateIdentifier}")
    public ResponseEntity<Page<Movie>> findAllByCertificateIdentifier(@PathVariable UUID certificateIdentifier, @PageableDefault(size = 12) Pageable pageable) {
        return ResponseEntity.ok().body(movieSearchService.findAllByCertificateIdentifier(certificateIdentifier, pageable));
    }

    @GetMapping("/title/{title}")
    public ResponseEntity<Page<Movie>> findAllByTitle(@PathVariable String title, @PageableDefault(size = 12) Pageable pageable) {
        return ResponseEntity.ok().body(movieSearchService.findAllByTitle(title, pageable));
    }

    @GetMapping("/upcoming")
    public ResponseEntity<Page<Movie>> upcoming(@PageableDefault(size = 12) Pageable pageable) {
        return ResponseEntity.ok().body(movieSearchService.upcoming(pageable));
    }

    @GetMapping("/latest")
    public ResponseEntity<Page<Movie>> latest(@PageableDefault(size = 12) Pageable pageable) {
        return ResponseEntity.ok().body(movieSearchService.latest(pageable));
    }
}
