package com.cinelist.ms.catalog.controllers.register.impl;

import com.cinelist.ms.catalog.database.models.Genre;
import com.cinelist.ms.catalog.dtos.genres.GenreRequest;
import com.cinelist.ms.catalog.services.register.GenreRegisterService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/genres")
public class GenreRegisterControllerImpl {
    private final GenreRegisterService genreRegisterService;

    public GenreRegisterControllerImpl(GenreRegisterService genreRegisterService) {
        this.genreRegisterService = genreRegisterService;
    }

    @PostMapping
    public ResponseEntity<Genre> register(@RequestBody GenreRequest request) {
        Genre created = genreRegisterService.register(request);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{identifier}").buildAndExpand(created.getIdentifier()).toUri();

        return ResponseEntity.created(uri).body(created);
    }
}