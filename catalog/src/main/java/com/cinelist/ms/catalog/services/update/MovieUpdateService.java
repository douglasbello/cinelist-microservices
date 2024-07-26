package com.cinelist.ms.catalog.services.update;

import com.cinelist.ms.catalog.dtos.movies.MovieRequest;

import java.util.UUID;

public interface MovieUpdateService {
    void addGenreToMovie(UUID genreIdentifier, UUID movieIdentifier);
    void addPlatformToMovie(UUID platformIdentifier, UUID movieIdentifier);
    void updateInfo(UUID movieIdentifier, MovieRequest request);
}