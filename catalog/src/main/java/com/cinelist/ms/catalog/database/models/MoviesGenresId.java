package com.cinelist.ms.catalog.database.models;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.util.UUID;

@Embeddable
public class MoviesGenresId {
    @Column(name = "movie_identifier", length = 36)
    private UUID movieIdentifier;
    @Column(name = "genre_identifier", length = 36)
    private UUID genreIdentifier;

    public MoviesGenresId() {
    }

    public MoviesGenresId(UUID movieIdentifier, UUID genreIdentifier) {
        this.movieIdentifier = movieIdentifier;
        this.genreIdentifier = genreIdentifier;
    }

    public UUID getMovieIdentifier() {
        return movieIdentifier;
    }

    public void setMovieIdentifier(UUID movieIdentifier) {
        this.movieIdentifier = movieIdentifier;
    }

    public UUID getGenreIdentifier() {
        return genreIdentifier;
    }

    public void setGenreIdentifier(UUID genreIdentifier) {
        this.genreIdentifier = genreIdentifier;
    }
}