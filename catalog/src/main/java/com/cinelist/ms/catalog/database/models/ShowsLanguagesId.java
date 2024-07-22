package com.cinelist.ms.catalog.database.models;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.util.UUID;

@Embeddable
public class ShowsLanguagesId {
    @Column(name = "show_identifier", length = 36)
    private UUID showIdentifier;
    @Column(name = "language_identifier", length = 36)
    private UUID languageIdentifier;

    public ShowsLanguagesId() {
    }

    public ShowsLanguagesId(UUID showIdentifier, UUID languageIdentifier) {
        this.showIdentifier = showIdentifier;
        this.languageIdentifier = languageIdentifier;
    }

    public UUID getShowIdentifier() {
        return showIdentifier;
    }

    public void setShowIdentifier(UUID showIdentifier) {
        this.showIdentifier = showIdentifier;
    }

    public UUID getLanguageIdentifier() {
        return languageIdentifier;
    }

    public void setLanguageIdentifier(UUID languageIdentifier) {
        this.languageIdentifier = languageIdentifier;
    }
}