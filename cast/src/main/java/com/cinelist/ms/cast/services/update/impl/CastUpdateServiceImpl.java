package com.cinelist.ms.cast.services.update.impl;

import com.cinelist.ms.cast.client.MoviesClient;
import com.cinelist.ms.cast.database.models.Cast;
import com.cinelist.ms.cast.database.models.CastMovie;
import com.cinelist.ms.cast.database.repositories.CastMovieRepository;
import com.cinelist.ms.cast.dtos.client.MovieResponse;
import com.cinelist.ms.cast.services.search.CastSearchService;
import com.cinelist.ms.cast.services.update.CastUpdateService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class CastUpdateServiceImpl implements CastUpdateService {
    private final MoviesClient moviesClient;
    private final CastMovieRepository castMovieRepository;
    private final CastSearchService castSearchService;

    public CastUpdateServiceImpl(MoviesClient moviesClient, CastMovieRepository castMovieRepository, CastSearchService castSearchService) {
        this.moviesClient = moviesClient;
        this.castMovieRepository = castMovieRepository;
        this.castSearchService = castSearchService;
    }

    @Override
    public void addMovieToCast(UUID castIdentifier, UUID movieIdentifier) {
        Cast castExists = castSearchService.findByIdentifier(castIdentifier);
        ResponseEntity<MovieResponse> movieExists = moviesClient.findByIdentifier(movieIdentifier);

        CastMovie castMovie = new CastMovie(castIdentifier, movieIdentifier);
        castMovieRepository.save(castMovie);
    }
}