package com.cinelist.ms.catalog.services.search;

import com.cinelist.ms.catalog.database.models.Movie;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface MovieSearchService {
    Movie findByIdentifier(String identifier);
    Page<Movie> findAll(Pageable pageable);
    Page<Movie> findAllByGenreIdentifier(String genreIdentifier, Pageable pageable);
    Page<Movie> findAllByPlatformIdentifier(String platformIdentifier, Pageable pageable);
    Page<Movie> findAllByLanguageIdentifier(String languageIdentifier, Pageable pageable);
    Page<Movie> findAllByCertificateIdentifier(String certificateIdentifier, Pageable pageable);
}