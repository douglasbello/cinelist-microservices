package com.cinelist.ms.catalog.services.search.impl;

import com.cinelist.ms.catalog.database.models.Movie;
import com.cinelist.ms.catalog.database.models.MoviesGenres;
import com.cinelist.ms.catalog.database.models.MoviesPlatforms;
import com.cinelist.ms.catalog.database.repositories.MovieRepository;
import com.cinelist.ms.catalog.database.repositories.MoviesGenresRepository;
import com.cinelist.ms.catalog.database.repositories.MoviesPlatformsRepository;
import com.cinelist.ms.catalog.handlers.exceptions.ResourceNotFoundException;
import com.cinelist.ms.catalog.services.search.MovieSearchService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class MovieSearchServiceImpl implements MovieSearchService {
    private final MovieRepository movieRepository;
    private final MoviesGenresRepository moviesGenresRepository;
    private final MoviesPlatformsRepository moviesPlatformsRepository;

    public MovieSearchServiceImpl(MovieRepository movieRepository,
                                  MoviesGenresRepository moviesGenresRepository,
                                  MoviesPlatformsRepository moviesPlatformsRepository) {
        this.movieRepository = movieRepository;
        this.moviesGenresRepository = moviesGenresRepository;
        this.moviesPlatformsRepository = moviesPlatformsRepository;
    }

    @Override
    public Page<Movie> findAll(Pageable pageable) {
        return movieRepository.findAll(pageable);
    }

    @Override
    public Movie findByIdentifier(UUID identifier) {
        return movieRepository.findById(identifier).orElseThrow(() -> new ResourceNotFoundException("Movie", identifier.toString()));
    }

    // todo: test if the pagination is really working here
    @Override
    public Page<Movie> findAllByGenreIdentifier(UUID genreIdentifier, Pageable pageable) {
        Page<MoviesGenres> data = moviesGenresRepository.findAllByGenreIdentifier(genreIdentifier, pageable);

        List<Movie> movies = data.stream().map(moviesGenres -> findByIdentifier(moviesGenres.getMovieIdentifier())).toList();

        return new PageImpl<>(movies);
    }

    @Override
    public Page<Movie> findAllByPlatformIdentifier(UUID platformIdentifier, Pageable pageable) {
        Page<MoviesPlatforms> data = moviesPlatformsRepository.findAllByPlatformIdentifier(platformIdentifier, pageable);

        List<Movie> movies = data.stream().map(moviesPlatforms -> findByIdentifier(moviesPlatforms.getMovieIdentifier())).toList();

        return new PageImpl<>(movies);
    }

    @Override
    public Page<Movie> findAllByLanguageIdentifier(UUID languageIdentifier, Pageable pageable) {
        return movieRepository.findAllByLanguageIdentifier(languageIdentifier, pageable);
    }

    @Override
    public Page<Movie> findAllByCertificateIdentifier(UUID certificateIdentifier, Pageable pageable) {
        return movieRepository.findAllByCertificateIdentifier(certificateIdentifier, pageable);
    }

    @Override
    public Page<Movie> findAllByTitle(String title, Pageable pageable) {
        return movieRepository.findAllByTitle(title, pageable);
    }
}