package com.cinelist.ms.catalog.services.register.impl;

import com.cinelist.ms.catalog.database.models.Movie;
import com.cinelist.ms.catalog.database.repositories.MovieRepository;
import com.cinelist.ms.catalog.dtos.movies.MovieRequest;
import com.cinelist.ms.catalog.services.register.MovieRegisterService;
import org.springframework.stereotype.Service;

@Service
public class MovieRegisterServiceImpl implements MovieRegisterService {
    private final MovieRepository movieRepository;

    public MovieRegisterServiceImpl(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    @Override
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