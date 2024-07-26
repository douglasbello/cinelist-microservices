package com.cinelist.ms.catalog.services.update.impl;

import com.cinelist.ms.catalog.database.models.*;
import com.cinelist.ms.catalog.database.repositories.MovieRepository;
import com.cinelist.ms.catalog.database.repositories.MoviesGenresRepository;
import com.cinelist.ms.catalog.database.repositories.MoviesPlatformsRepository;
import com.cinelist.ms.catalog.dtos.movies.MovieRequest;
import com.cinelist.ms.catalog.services.search.*;
import com.cinelist.ms.catalog.services.update.MovieUpdateService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
public class MovieUpdateServiceImpl implements MovieUpdateService {
    private final GenreSearchService genreSearchService;
    private final MovieSearchService movieSearchService;
    private final MoviesGenresRepository moviesGenresRepository;
    private final PlatformSearchService platformSearchService;
    private final MoviesPlatformsRepository moviesPlatformsRepository;
    private final CertificateSearchService certificateSearchService;
    private final LanguageSearchService languageSearchService;
    private final MovieRepository movieRepository;

    public MovieUpdateServiceImpl(GenreSearchService genreSearchService, MovieSearchService movieSearchService, MoviesGenresRepository moviesGenresRepository,
                                  PlatformSearchService platformSearchService, MoviesPlatformsRepository moviesPlatformsRepository, CertificateSearchService certificateSearchService,
                                  LanguageSearchService languageSearchService, MovieRepository movieRepository) {
        this.genreSearchService = genreSearchService;
        this.movieSearchService = movieSearchService;
        this.moviesGenresRepository = moviesGenresRepository;
        this.platformSearchService = platformSearchService;
        this.moviesPlatformsRepository = moviesPlatformsRepository;
        this.certificateSearchService = certificateSearchService;
        this.languageSearchService = languageSearchService;
        this.movieRepository = movieRepository;
    }

    @Override
    public void addGenreToMovie(UUID genreIdentifier, UUID movieIdentifier) {
        Genre genre = genreSearchService.findByIdentifier(genreIdentifier);
        Movie movie = movieSearchService.findByIdentifier(movieIdentifier);

        MoviesGenresId moviesGenresId = new MoviesGenresId(movieIdentifier, genreIdentifier);
        MoviesGenres moviesGenres = new MoviesGenres(moviesGenresId);

        moviesGenresRepository.save(moviesGenres);
    }

    @Override
    public void addPlatformToMovie(UUID platformIdentifier, UUID movieIdentifier) {
        Platform platform = platformSearchService.findByIdentifier(platformIdentifier);
        Movie movie = movieSearchService.findByIdentifier(movieIdentifier);

        MoviesPlatformsId moviesPlatformsId = new MoviesPlatformsId(movieIdentifier, platformIdentifier);
        MoviesPlatforms moviesPlatforms = new MoviesPlatforms(moviesPlatformsId);

        moviesPlatformsRepository.save(moviesPlatforms);
    }

    @Transactional
    @Override
    public void updateInfo(UUID movieIdentifier, MovieRequest request) {
        Movie old = movieSearchService.findByIdentifier(movieIdentifier);

        updateData(old, request);

        movieRepository.save(old);

        if (request.platformsIdentifiers() != null)
            request.platformsIdentifiers().forEach(identifier -> addPlatformToMovie(identifier, movieIdentifier));

        if (request.genresIdentifiers() != null)
            request.genresIdentifiers().forEach(identifier -> addGenreToMovie(identifier, movieIdentifier));
    }

    private void updateData(Movie old, MovieRequest request) {
        if (request.certificateIdentifier() != null)
            certificateSearchService.findByIdentifier(request.certificateIdentifier());

        if (request.languageIdentifier() != null)
            languageSearchService.findByIdentifier(request.languageIdentifier());

        old.setDuration(request.duration());
        old.setReleaseDate(request.releaseDate());
        old.setTitle(request.title());
        old.setLongDescription(request.longDescription());
        old.setShortDescription(request.shortDescription());
        old.setThumbnailUrl(request.thumbnailUrl());
        old.setTrailerUrl(request.trailerUrl());
        old.setLanguageIdentifier(request.languageIdentifier());
        old.setCertificateIdentifier(request.certificateIdentifier());
    }
}