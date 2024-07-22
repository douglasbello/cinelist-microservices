package com.cinelist.ms.catalog.database.models;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.util.UUID;

@Embeddable
public class MoviesLanguagesId {
    @Column(name = "movie_identifier")
    private UUID movieIdentifier;
    @Column(name = "language_identifier")
    private UUID languageIdentifier;

    public MoviesLanguagesId() {
    }

    public MoviesLanguagesId(UUID movieIdentifier, UUID languageIdentifier) {
        this.movieIdentifier = movieIdentifier;
        this.languageIdentifier = languageIdentifier;
    }

    public UUID getMovieIdentifier() {
        return movieIdentifier;
    }

    public void setMovieIdentifier(UUID movieIdentifier) {
        this.movieIdentifier = movieIdentifier;
    }

    public UUID getLanguageIdentifier() {
        return languageIdentifier;
    }

    public void setLanguageIdentifier(UUID languageIdentifier) {
        this.languageIdentifier = languageIdentifier;
    }
}