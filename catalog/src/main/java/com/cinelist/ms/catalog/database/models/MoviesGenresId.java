package com.cinelist.ms.catalog.database.models;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class MoviesGenresId {
    @Column(name = "movieIdentifier", length = 36)
    private String movieIdentifier;
    @Column(name = "genreIdentifier", length = 36)
    private String genreIdentifier;

    public MoviesGenresId() {
    }

    public MoviesGenresId(String movieIdentifier, String genreIdentifier) {
        this.movieIdentifier = movieIdentifier;
        this.genreIdentifier = genreIdentifier;
    }

    public String getMovieIdentifier() {
        return movieIdentifier;
    }

    public void setMovieIdentifier(String movieIdentifier) {
        this.movieIdentifier = movieIdentifier;
    }

    public String getGenreIdentifier() {
        return genreIdentifier;
    }

    public void setGenreIdentifier(String genreIdentifier) {
        this.genreIdentifier = genreIdentifier;
    }
}