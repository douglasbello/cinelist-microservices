package com.cinelist.ms.catalog.services.register.impl;

import com.cinelist.ms.catalog.database.models.Movie;
import com.cinelist.ms.catalog.database.repositories.MovieRepository;
import com.cinelist.ms.catalog.dtos.movies.MovieRequest;
import com.cinelist.ms.catalog.handlers.exceptions.ResourceNotFoundException;
import com.cinelist.ms.catalog.services.register.MovieRegisterService;
import com.cinelist.ms.catalog.services.search.CertificateSearchService;
import com.cinelist.ms.catalog.services.update.MovieUpdateService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
public class MovieRegisterServiceImpl implements MovieRegisterService {
    private final MovieRepository movieRepository;
    private final CertificateSearchService certificateSearchService;
    private final MovieUpdateService movieUpdateService;

    public MovieRegisterServiceImpl(MovieRepository movieRepository, CertificateSearchService certificateSearchService,
                                    MovieUpdateService movieUpdateService) {
        this.movieRepository = movieRepository;
        this.certificateSearchService = certificateSearchService;
        this.movieUpdateService = movieUpdateService;
    }

    @Transactional
    public Movie register(MovieRequest request) {
        boolean certificateExists = certificateSearchService.exists(request.certificateIdentifier());

        if (request.certificateIdentifier() != null && !certificateExists)
            throw new ResourceNotFoundException("Certificate", request.certificateIdentifier().toString());

        Movie movie = new Movie.MovieBuilder()
                .setTitle(request.title())
                .setCertificateId(request.certificateIdentifier())
                .setDuration(request.duration())
                .setShortDescription(request.shortDescription())
                .setLongDescription(request.longDescription())
                .setTrailerUrl(request.trailerUrl())
                .setThumbnailUrl(request.thumbnailUrl())
                .setReleaseDate(request.releaseDate())
                .build();

        movie = movieRepository.save(movie);
        UUID movieIdentifier = movie.getIdentifier();

        request.platformsIdentifiers().forEach(identifier -> movieUpdateService.addPlatformToMovie(identifier, movieIdentifier));
        request.languagesIdentifiers().forEach(identifier -> movieUpdateService.addLanguageToMovie(identifier, movieIdentifier));
        request.genresIdentifiers().forEach(identifier -> movieUpdateService.addGenreToMovie(identifier, movieIdentifier));

        return movie;
    }
}