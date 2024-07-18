package com.cinelist.ms.catalog.services.movies.impl;

import com.cinelist.ms.catalog.database.models.Movie;
import com.cinelist.ms.catalog.database.repositories.MovieRepository;
import com.cinelist.ms.catalog.dtos.movies.MovieRequest;
import com.cinelist.ms.catalog.services.movies.MovieService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class MovieServiceImpl implements MovieService {
    private final MovieRepository movieRepository;

    public MovieServiceImpl(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public Page<Movie> findAll(Pageable pageable) {
        return null;
    }

    public Movie findByIdentifier(String identifier) {
        return null;
    }

    public Page<Movie> findByGenreIdentifier(String genreIdentifier, Pageable pageable) {
        return null;
    }

    public Page<Movie> findByPlatformIdentifier(String platformIdentifier, Pageable pageable) {
        return null;
    }

    public Page<Movie> findByLanguageIdentifier(String languageIdentifier, Pageable pageable) {
        return null;
    }

    public Movie register(MovieRequest request) {
        Movie movie = new Movie.MovieBuilder()
                .setTitle(request.title())
                .setCertificateId(request.certificateId())
                .setDuration(request.duration())
                .setShortDescription(request.shortDescription())
                .setLongDescription(request.longDescription())
                .setTrailerUrl(request.trailerUrl())
                .setThumbnailUrl(request.thumbnailUrl())
                .setReleaseDate(request.releaseDate())
                .build();

        return movieRepository.save(movie);
    }
}