package com.cinelist.ms.catalog.services.register.impl;

import com.cinelist.ms.catalog.database.models.Genre;
import com.cinelist.ms.catalog.database.repositories.GenreRepository;
import com.cinelist.ms.catalog.dtos.genres.GenreRequest;
import com.cinelist.ms.catalog.services.register.GenreRegisterService;
import org.springframework.stereotype.Service;

@Service
public class GenreRegisterServiceImpl implements GenreRegisterService {
    private final GenreRepository genreRepository;

    public GenreRegisterServiceImpl(GenreRepository genreRepository) {
        this.genreRepository = genreRepository;
    }

    @Override
    public Genre register(GenreRequest request) {
        Genre genre = new Genre(request.name());

        return genreRepository.save(genre);
    }
}