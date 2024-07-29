package com.cinelist.ms.cast.database.models;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.util.UUID;

@Embeddable
public class CastMovieId {
    @Column(name = "cast_identifier", length = 36)
    private UUID castIdentifier;
    @Column(name = "movie_identifier", length = 36)
    private UUID movieIdentifier;

    public CastMovieId() {
    }

    public CastMovieId(UUID castIdentifier, UUID movieIdentifier) {
        this.castIdentifier = castIdentifier;
        this.movieIdentifier = movieIdentifier;
    }

    public UUID getCastIdentifier() {
        return castIdentifier;
    }

    public void setCastIdentifier(UUID castIdentifier) {
        this.castIdentifier = castIdentifier;
    }

    public UUID getMovieIdentifier() {
        return movieIdentifier;
    }

    public void setMovieIdentifier(UUID movieIdentifier) {
        this.movieIdentifier = movieIdentifier;
    }
}