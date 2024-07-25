package com.cinelist.ms.catalog.services.search.impl;

import com.cinelist.ms.catalog.database.models.Genre;
import com.cinelist.ms.catalog.database.repositories.GenreRepository;
import com.cinelist.ms.catalog.handlers.exceptions.ResourceNotFoundException;
import com.cinelist.ms.catalog.services.search.GenreSearchService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class GenreSearchServiceImpl implements GenreSearchService {
    private final GenreRepository genreRepository;

    public GenreSearchServiceImpl(GenreRepository genreRepository) {
        this.genreRepository = genreRepository;
    }

    @Override
    public Genre findByIdentifier(UUID identifier) {
        return genreRepository.findById(identifier).orElseThrow(() -> new ResourceNotFoundException("Genre", identifier.toString()));
    }

    @Override
    public Genre findByName(String name) {
        return genreRepository.findByName(name);
    }

    @Override
    public Page<Genre> findAll(Pageable pageable) {
        return genreRepository.findAll(pageable);
    }
}