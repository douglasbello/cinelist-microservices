package com.cinelist.ms.catalog.controllers.search.impl;

import com.cinelist.ms.catalog.controllers.search.GenreSearchController;
import com.cinelist.ms.catalog.database.models.Genre;
import com.cinelist.ms.catalog.services.search.GenreSearchService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/genres")
public class GenreSearchControllerImpl implements GenreSearchController {
    private final GenreSearchService genreSearchService;

    public GenreSearchControllerImpl(GenreSearchService genreSearchService) {
        this.genreSearchService = genreSearchService;
    }

    @GetMapping("/{name}")
    public ResponseEntity<Genre> findByName(@PathVariable String name) {
        return ResponseEntity.ok().body(genreSearchService.findByName(name));
    }
}