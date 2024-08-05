package com.cinelist.ms.ratings.database.models;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.util.UUID;

@Embeddable
public class MovieRatingId {
    @Column(name = "movie_identifier", length = 36)
    private UUID movieIdentifier;
    @Column(name = "rating_identifier", length = 36)
    private UUID ratingIdentifier;

    public MovieRatingId() {
    }

    public MovieRatingId(UUID movieIdentifier, UUID ratingIdentifier) {
        this.movieIdentifier = movieIdentifier;
        this.ratingIdentifier = ratingIdentifier;
    }

    public UUID getMovieIdentifier() {
        return movieIdentifier;
    }

    public void setMovieIdentifier(UUID movieIdentifier) {
        this.movieIdentifier = movieIdentifier;
    }

    public UUID getRatingIdentifier() {
        return ratingIdentifier;
    }

    public void setRatingIdentifier(UUID ratingIdentifier) {
        this.ratingIdentifier = ratingIdentifier;
    }
}