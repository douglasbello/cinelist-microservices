package com.cinelist.ms.cast.services.update.impl;

import com.cinelist.ms.cast.client.MoviesClient;
import com.cinelist.ms.cast.database.models.Cast;
import com.cinelist.ms.cast.database.models.CastMovie;
import com.cinelist.ms.cast.database.models.CastOccupation;
import com.cinelist.ms.cast.database.models.Occupation;
import com.cinelist.ms.cast.database.repositories.CastMovieRepository;
import com.cinelist.ms.cast.database.repositories.CastOccupationRepository;
import com.cinelist.ms.cast.dtos.castmovie.CastMovieRequest;
import com.cinelist.ms.cast.dtos.client.MovieResponse;
import com.cinelist.ms.cast.services.search.CastSearchService;
import com.cinelist.ms.cast.services.search.OccupationSearchService;
import com.cinelist.ms.cast.services.update.CastUpdateService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class CastUpdateServiceImpl implements CastUpdateService {
    private final MoviesClient moviesClient;
    private final CastMovieRepository castMovieRepository;
    private final CastSearchService castSearchService;
    private final OccupationSearchService occupationSearchService;
    private final CastOccupationRepository castOccupationRepository;

    public CastUpdateServiceImpl(MoviesClient moviesClient, CastMovieRepository castMovieRepository,
                                 CastSearchService castSearchService, OccupationSearchService occupationSearchService, CastOccupationRepository castOccupationRepository) {
        this.moviesClient = moviesClient;
        this.castMovieRepository = castMovieRepository;
        this.castSearchService = castSearchService;
        this.occupationSearchService = occupationSearchService;
        this.castOccupationRepository = castOccupationRepository;
    }

    @Override
    public void addCastToMovie(CastMovieRequest request) {
        Cast castExists = castSearchService.findByIdentifier(request.castIdentifier());
        ResponseEntity<MovieResponse> movieExists = moviesClient.findByIdentifier(request.movieIdentifier());

        CastMovie castMovie = new CastMovie(request.castIdentifier(), request.movieIdentifier(), request.character());
        castMovieRepository.save(castMovie);
    }

    @Override
    public void addOccupationToCast(UUID castIdentifier, UUID occupationIdentifier) {
        Cast castExists = castSearchService.findByIdentifier(castIdentifier);
        Occupation occupationExists = occupationSearchService.findByIdentifier(occupationIdentifier);

        CastOccupation relation = new CastOccupation(castIdentifier, occupationIdentifier);
        castOccupationRepository.save(relation);
    }
}