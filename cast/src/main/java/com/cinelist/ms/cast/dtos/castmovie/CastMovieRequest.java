package com.cinelist.ms.cast.dtos.castmovie;

import java.util.UUID;

public record CastMovieRequest(UUID castIdentifier, UUID movieIdentifier, String character) {
}