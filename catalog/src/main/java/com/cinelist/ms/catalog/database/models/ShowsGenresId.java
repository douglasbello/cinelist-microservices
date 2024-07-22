package com.cinelist.ms.catalog.database.models;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.util.UUID;

@Embeddable
public class ShowsGenresId {
    @Column(name = "show_identifier", length = 36)
    private UUID showIdentifier;
    @Column(name = "genre_identifier", length = 36)
    private UUID genreIdentifier;

    public ShowsGenresId() {
    }

    public ShowsGenresId(UUID showIdentifier, UUID genreIdentifier) {
        this.showIdentifier = showIdentifier;
        this.genreIdentifier = genreIdentifier;
    }

    public UUID getShowIdentifier() {
        return showIdentifier;
    }

    public void setShowIdentifier(UUID showIdentifier) {
        this.showIdentifier = showIdentifier;
    }

    public UUID getGenreIdentifier() {
        return genreIdentifier;
    }

    public void setGenreIdentifier(UUID genreIdentifier) {
        this.genreIdentifier = genreIdentifier;
    }
}