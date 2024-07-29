package com.cinelist.ms.cast.services.update.impl;

import com.cinelist.ms.cast.client.MoviesClient;
import com.cinelist.ms.cast.database.models.CastMovie;
import com.cinelist.ms.cast.database.repositories.CastMovieRepository;
import com.cinelist.ms.cast.database.repositories.CastRepository;
import com.cinelist.ms.cast.dtos.client.MovieResponse;
import com.cinelist.ms.cast.handlers.exceptions.ResourceNotFoundException;
import com.cinelist.ms.cast.services.update.CastUpdateService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class CastUpdateServiceImpl implements CastUpdateService {
    private final CastRepository castRepository;
    private final MoviesClient moviesClient;
    private final CastMovieRepository castMovieRepository;

    public CastUpdateServiceImpl(CastRepository castRepository, MoviesClient moviesClient, CastMovieRepository castMovieRepository) {
        this.castRepository = castRepository;
        this.moviesClient = moviesClient;
        this.castMovieRepository = castMovieRepository;
    }

    @Override
    public void addMovieToCast(UUID castIdentifier, UUID movieIdentifier) {
        ResponseEntity<MovieResponse> movieExists = moviesClient.findByIdentifier(movieIdentifier);

        if (movieExists.getStatusCode().value() == 404)
            throw new ResourceNotFoundException("Movie", movieIdentifier);

        CastMovie castMovie = new CastMovie(castIdentifier, movieIdentifier);
        castMovieRepository.save(castMovie);
    }
}