package com.cinelist.ms.catalog.services.movies;

import com.cinelist.ms.catalog.database.models.Movie;
import com.cinelist.ms.catalog.dtos.movies.MovieRequest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface MovieService {
    Page<Movie> findAll(Pageable pageable);
    Movie findByIdentifier(String identifier);
    Page<Movie> findByGenreIdentifier(String genreIdentifier, Pageable pageable);
    Page<Movie> findByPlatformIdentifier(String platformIdentifier, Pageable pageable);
    Page<Movie> findByLanguageIdentifier(String languageIdentifier, Pageable pageable);
    Movie register(MovieRequest dto);
}