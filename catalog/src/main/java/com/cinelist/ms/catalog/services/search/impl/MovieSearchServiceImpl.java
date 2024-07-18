package com.cinelist.ms.catalog.services.search.impl;

import com.cinelist.ms.catalog.database.models.Movie;
import com.cinelist.ms.catalog.database.models.MoviesGenres;
import com.cinelist.ms.catalog.database.models.MoviesLanguages;
import com.cinelist.ms.catalog.database.models.MoviesPlatforms;
import com.cinelist.ms.catalog.database.repositories.MovieRepository;
import com.cinelist.ms.catalog.database.repositories.MoviesGenresRepository;
import com.cinelist.ms.catalog.database.repositories.MoviesLanguagesRepository;
import com.cinelist.ms.catalog.database.repositories.MoviesPlatformsRepository;
import com.cinelist.ms.catalog.handlers.exceptions.ResourceNotFoundException;
import com.cinelist.ms.catalog.services.search.MovieSearchService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieSearchServiceImpl implements MovieSearchService {
    private final MovieRepository movieRepository;
    private final MoviesGenresRepository moviesGenresRepository;
    private final MoviesPlatformsRepository moviesPlatformsRepository;
    private final MoviesLanguagesRepository moviesLanguagesRepository;

    public MovieSearchServiceImpl(MovieRepository movieRepository,
                                  MoviesGenresRepository moviesGenresRepository,
                                  MoviesPlatformsRepository moviesPlatformsRepository,
                                  MoviesLanguagesRepository moviesLanguagesRepository) {
        this.movieRepository = movieRepository;
        this.moviesGenresRepository = moviesGenresRepository;
        this.moviesPlatformsRepository = moviesPlatformsRepository;
        this.moviesLanguagesRepository = moviesLanguagesRepository;
    }

    @Override
    public Page<Movie> findAll(Pageable pageable) {
        return movieRepository.findAll(pageable);
    }

    @Override
    public Movie findByIdentifier(String identifier) {
        return movieRepository.findById(identifier).orElseThrow(() -> new ResourceNotFoundException(identifier));
    }

    // todo: test if the pagination is really working here
    @Override
    public Page<Movie> findAllByGenreIdentifier(String genreIdentifier, Pageable pageable) {
        Page<MoviesGenres> data = moviesGenresRepository.findAllByGenreIdentifier(genreIdentifier, pageable);

        List<Movie> movies = data.stream().map(moviesGenres -> findByIdentifier(moviesGenres.getMovieIdentifier())).toList();

        return new PageImpl<>(movies);
    }

    @Override
    public Page<Movie> findAllByPlatformIdentifier(String platformIdentifier, Pageable pageable) {
        Page<MoviesPlatforms> data = moviesPlatformsRepository.findAllByPlatformIdentifier(platformIdentifier, pageable);

        List<Movie> movies = data.stream().map(moviesPlatforms -> findByIdentifier(moviesPlatforms.getMovieIdentifier())).toList();

        return new PageImpl<>(movies);
    }

    @Override
    public Page<Movie> findAllByLanguageIdentifier(String languageIdentifier, Pageable pageable) {
        Page<MoviesLanguages> data = moviesLanguagesRepository.findAllByLanguageIdentifier(languageIdentifier, pageable);

        List<Movie> movies = data.stream().map(moviesLanguages -> findByIdentifier(moviesLanguages.getMovieIdentifier())).toList();

        return new PageImpl<>(movies);
    }

    @Override
    public Page<Movie> findAllByCertificateIdentifier(String certificateIdentifier, Pageable pageable) {
        return movieRepository.findAllByCertificateIdentifier(certificateIdentifier, pageable);
    }
}