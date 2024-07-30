package com.cinelist.ms.cast.services.update;

import com.cinelist.ms.cast.dtos.castmovie.CastMovieRequest;

import java.util.UUID;

public interface CastUpdateService {
    void addCastToMovie(CastMovieRequest request);
    void addOccupationToCast(UUID castIdentifier, UUID occupationIdentifier);
}