package com.cinelist.ms.catalog.services.search;

import com.cinelist.ms.catalog.database.models.Movie;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.UUID;

public interface MovieSearchService {
    Movie findByIdentifier(UUID identifier);
    Page<Movie> findAll(Pageable pageable);
    Page<Movie> findAllByGenreIdentifier(UUID genreIdentifier, Pageable pageable);
    Page<Movie> findAllByPlatformIdentifier(UUID platformIdentifier, Pageable pageable);
    Page<Movie> findAllByLanguageIdentifier(UUID languageIdentifier, Pageable pageable);
    Page<Movie> findAllByCertificateIdentifier(UUID certificateIdentifier, Pageable pageable);
    Page<Movie> findAllByTitle(String title, Pageable pageable);
    Page<Movie> upcoming(Pageable pageable);
    Page<Movie> latest(Pageable pageable);
}