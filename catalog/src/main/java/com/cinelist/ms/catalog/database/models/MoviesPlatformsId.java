package com.cinelist.ms.catalog.database.models;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class MoviesPlatformsId {
    @Column(name = "movie_identifier", length = 36)
    private String movieIdentifier;
    @Column(name = "platform_identifier", length = 36)
    private String platformIdentifier;

    public MoviesPlatformsId() {
    }

    public MoviesPlatformsId(String movieIdentifier, String platformIdentifier) {
        this.movieIdentifier = movieIdentifier;
        this.platformIdentifier = platformIdentifier;
    }

    public String getPlatformIdentifier() {
        return platformIdentifier;
    }

    public void setPlatformIdentifier(String platformIdentifier) {
        this.platformIdentifier = platformIdentifier;
    }

    public String getMovieIdentifier() {
        return movieIdentifier;
    }

    public void setMovieIdentifier(String movieIdentifier) {
        this.movieIdentifier = movieIdentifier;
    }
}