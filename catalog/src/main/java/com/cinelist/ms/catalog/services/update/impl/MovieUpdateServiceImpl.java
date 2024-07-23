package com.cinelist.ms.catalog.services.update.impl;

import com.cinelist.ms.catalog.database.models.*;
import com.cinelist.ms.catalog.database.repositories.MoviesGenresRepository;
import com.cinelist.ms.catalog.database.repositories.MoviesLanguagesRepository;
import com.cinelist.ms.catalog.database.repositories.MoviesPlatformsRepository;
import com.cinelist.ms.catalog.services.search.GenreSearchService;
import com.cinelist.ms.catalog.services.search.LanguageSearchService;
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
    private final LanguageSearchService languageSearchService;
    private final MoviesLanguagesRepository moviesLanguagesRepository;

    public MovieUpdateServiceImpl(GenreSearchService genreSearchService, MovieSearchService movieSearchService, MoviesGenresRepository moviesGenresRepository,
                                  PlatformSearchService platformSearchService, MoviesPlatformsRepository moviesPlatformsRepository, LanguageSearchService languageSearchService, MoviesLanguagesRepository moviesLanguagesRepository) {
        this.genreSearchService = genreSearchService;
        this.movieSearchService = movieSearchService;
        this.moviesGenresRepository = moviesGenresRepository;
        this.platformSearchService = platformSearchService;
        this.moviesPlatformsRepository = moviesPlatformsRepository;
        this.languageSearchService = languageSearchService;
        this.moviesLanguagesRepository = moviesLanguagesRepository;
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
        Language language = languageSearchService.findByIdentifier(languageIdentifier);
        Movie movie = movieSearchService.findByIdentifier(movieIdentifier);

        MoviesLanguagesId moviesLanguagesId = new MoviesLanguagesId(movieIdentifier, languageIdentifier);
        MoviesLanguages moviesLanguages = new MoviesLanguages(moviesLanguagesId);

        moviesLanguagesRepository.save(moviesLanguages);
    }
}