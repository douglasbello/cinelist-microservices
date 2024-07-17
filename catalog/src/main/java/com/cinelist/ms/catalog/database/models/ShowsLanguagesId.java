package com.cinelist.ms.catalog.database.models;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class ShowsLanguagesId {
    @Column(name = "show_identifier", length = 36)
    private String showIdentifier;
    @Column(name = "language_identifier", length = 36)
    private String languageIdentifier;

    public ShowsLanguagesId() {
    }

    public ShowsLanguagesId(String showIdentifier, String languageIdentifier) {
        this.showIdentifier = showIdentifier;
        this.languageIdentifier = languageIdentifier;
    }

    public String getShowIdentifier() {
        return showIdentifier;
    }

    public void setShowIdentifier(String showIdentifier) {
        this.showIdentifier = showIdentifier;
    }

    public String getLanguageIdentifier() {
        return languageIdentifier;
    }

    public void setLanguageIdentifier(String languageIdentifier) {
        this.languageIdentifier = languageIdentifier;
    }
}