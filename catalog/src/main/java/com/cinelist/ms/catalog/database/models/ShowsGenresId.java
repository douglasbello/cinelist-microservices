package com.cinelist.ms.catalog.database.models;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class ShowsGenresId {
    @Column(name = "show_identifier", length = 36)
    private String showIdentifier;
    @Column(name = "genre_identifier", length = 36)
    private String genreIdentifier;

    public ShowsGenresId() {
    }

    public ShowsGenresId(String showIdentifier, String genreIdentifier) {
        this.showIdentifier = showIdentifier;
        this.genreIdentifier = genreIdentifier;
    }

    public String getShowIdentifier() {
        return showIdentifier;
    }

    public void setShowIdentifier(String showIdentifier) {
        this.showIdentifier = showIdentifier;
    }

    public String getGenreIdentifier() {
        return genreIdentifier;
    }

    public void setGenreIdentifier(String genreIdentifier) {
        this.genreIdentifier = genreIdentifier;
    }
}