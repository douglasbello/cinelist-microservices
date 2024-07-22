package com.cinelist.ms.catalog.services.update.impl;

import com.cinelist.ms.catalog.database.models.*;
import com.cinelist.ms.catalog.database.repositories.MoviesGenresRepository;
import com.cinelist.ms.catalog.database.repositories.MoviesPlatformsRepository;
import com.cinelist.ms.catalog.services.search.GenreSearchService;
import com.cinelist.ms.catalog.services.search.MovieSearchService;
import com.cinelist.ms.catalog.services.search.PlatformSearchService;
import com.cinelist.ms.catalog.services.update.MovieUpdateService;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class MovieUpdateServiceImpl implements MovieUpdateService {
    private final GenreSearchService genreSearchService;
    private final MovieSearchService movieSearchService;
    private final MoviesGenresRepository moviesGenresRepository;
    private final PlatformSearchService platformSearchService;
    private final MoviesPlatformsRepository moviesPlatformsRepository;

    public MovieUpdateServiceImpl(GenreSearchService genreSearchService, MovieSearchService movieSearchService, MoviesGenresRepository moviesGenresRepository,
                                  PlatformSearchService platformSearchService, MoviesPlatformsRepository moviesPlatformsRepository) {
        this.genreSearchService = genreSearchService;
        this.movieSearchService = movieSearchService;
        this.moviesGenresRepository = moviesGenresRepository;
        this.platformSearchService = platformSearchService;
        this.moviesPlatformsRepository = moviesPlatformsRepository;
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

    @Override
    public void addLanguageToMovie(UUID languageIdentifier, UUID movieIdentifier) {
    }
}