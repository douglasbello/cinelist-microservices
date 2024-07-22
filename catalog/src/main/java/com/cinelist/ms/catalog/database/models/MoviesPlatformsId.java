package com.cinelist.ms.catalog.database.models;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.util.UUID;

@Embeddable
public class MoviesPlatformsId {
    @Column(name = "movie_identifier", length = 36)
    private UUID movieIdentifier;
    @Column(name = "platform_identifier", length = 36)
    private UUID platformIdentifier;

    public MoviesPlatformsId() {
    }

    public MoviesPlatformsId(UUID movieIdentifier, UUID platformIdentifier) {
        this.movieIdentifier = movieIdentifier;
        this.platformIdentifier = platformIdentifier;
    }

    public UUID getPlatformIdentifier() {
        return platformIdentifier;
    }

    public void setPlatformIdentifier(UUID platformIdentifier) {
        this.platformIdentifier = platformIdentifier;
    }

    public UUID getMovieIdentifier() {
        return movieIdentifier;
    }

    public void setMovieIdentifier(UUID movieIdentifier) {
        this.movieIdentifier = movieIdentifier;
    }
}