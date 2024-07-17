package com.cinelist.ms.catalog.services.movies.impl;

import com.cinelist.ms.catalog.database.models.Movie;
import com.cinelist.ms.catalog.database.repositories.MovieRepository;
import com.cinelist.ms.catalog.dtos.movies.MovieInputDto;
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

    public Movie register(MovieInputDto dto) {
        Movie movie = new Movie.MovieBuilder()
                .setTitle(dto.title())
                .setCertificateId(dto.certificateId())
                .setDuration(dto.duration())
                .setShortDescription(dto.shortDescription())
                .setLongDescription(dto.longDescription())
                .setTrailerUrl(dto.trailerUrl())
                .setThumbnailUrl(dto.thumbnailUrl())
                .setReleaseDate(dto.releaseDate())
                .build();

        return movieRepository.save(movie);
    }
}