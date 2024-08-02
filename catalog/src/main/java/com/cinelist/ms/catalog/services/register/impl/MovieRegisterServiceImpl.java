package com.cinelist.ms.catalog.services.register.impl;

import com.cinelist.ms.catalog.database.models.Movie;
import com.cinelist.ms.catalog.database.repositories.MovieRepository;
import com.cinelist.ms.catalog.dtos.movies.MovieRequest;
import com.cinelist.ms.catalog.handlers.exceptions.ResourceNotFoundException;
import com.cinelist.ms.catalog.services.register.MovieRegisterService;
import com.cinelist.ms.catalog.services.search.CertificateSearchService;
import com.cinelist.ms.catalog.services.search.LanguageSearchService;
import com.cinelist.ms.catalog.services.update.MovieUpdateService;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
public class MovieRegisterServiceImpl implements MovieRegisterService {
    private final MovieRepository movieRepository;
    private final CertificateSearchService certificateSearchService;
    private final MovieUpdateService movieUpdateService;
    private final LanguageSearchService languageSearchService;

    public MovieRegisterServiceImpl(MovieRepository movieRepository, CertificateSearchService certificateSearchService,
                                    MovieUpdateService movieUpdateService, LanguageSearchService languageSearchService) {
        this.movieRepository = movieRepository;
        this.certificateSearchService = certificateSearchService;
        this.movieUpdateService = movieUpdateService;
        this.languageSearchService = languageSearchService;
    }

    @CacheEvict(cacheNames = {
            "allMovies", "upcomingMovies", "latestMovies", "allMoviesByGenre", "allMoviesByPlatform", "allMoviesByLanguage", "allMoviesByCertificate",
            "allMoviesByTitle", "allMoviesByIdentifiers"
    }, allEntries = true)
    @Transactional
    public Movie register(MovieRequest request) {
        if (request.certificateIdentifier() != null)
            certificateSearchService.findByIdentifier(request.certificateIdentifier());

        if (request.languageIdentifier() != null)
            languageSearchService.findByIdentifier(request.languageIdentifier());

        Movie movie = new Movie.MovieBuilder()
                .setTitle(request.title())
                .setCertificateIdentifier(request.certificateIdentifier())
                .setLanguageIdentifier(request.languageIdentifier())
                .setDuration(request.duration())
                .setShortDescription(request.shortDescription())
                .setLongDescription(request.longDescription())
                .setTrailerUrl(request.trailerUrl())
                .setThumbnailUrl(request.thumbnailUrl())
                .setReleaseDate(request.releaseDate())
                .build();

        movie = movieRepository.save(movie);
        UUID movieIdentifier = movie.getIdentifier();

        if (request.platformsIdentifiers() != null)
            request.platformsIdentifiers().forEach(identifier -> movieUpdateService.addPlatformToMovie(identifier, movieIdentifier));

        if (request.genresIdentifiers() != null)
            request.genresIdentifiers().forEach(identifier -> movieUpdateService.addGenreToMovie(identifier, movieIdentifier));

        return movie;
    }
}