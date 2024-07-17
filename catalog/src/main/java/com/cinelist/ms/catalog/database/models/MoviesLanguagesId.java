package com.cinelist.ms.catalog.database.models;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class MoviesLanguagesId {
    @Column(name = "movieIdentifier")
    private String movieIdentifier;
    @Column(name = "languageIdentifier")
    private String languageIdentifier;

    public MoviesLanguagesId() {
    }

    public MoviesLanguagesId(String movieIdentifier, String languageIdentifier) {
        this.movieIdentifier = movieIdentifier;
        this.languageIdentifier = languageIdentifier;
    }

    public String getMovieIdentifier() {
        return movieIdentifier;
    }

    public void setMovieIdentifier(String movieIdentifier) {
        this.movieIdentifier = movieIdentifier;
    }

    public String getLanguageIdentifier() {
        return languageIdentifier;
    }

    public void setLanguageIdentifier(String languageIdentifier) {
        this.languageIdentifier = languageIdentifier;
    }
}