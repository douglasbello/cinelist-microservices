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
    @Column(name = "character", length = 80)
    private String character;

    public CastMovieId() {
    }

    public CastMovieId(UUID castIdentifier, UUID movieIdentifier) {
        this.castIdentifier = castIdentifier;
        this.movieIdentifier = movieIdentifier;
    }

    public CastMovieId(UUID castIdentifier, UUID movieIdentifier, String character) {
        this.castIdentifier = castIdentifier;
        this.movieIdentifier = movieIdentifier;
        this.character = character;
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

    public String getCharacter() {
        return character;
    }

    public void setCharacter(String character) {
        this.character = character;
    }
}