package com.cinelist.ms.catalog.database.models;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "tb_shows_languages")
public class ShowsLanguages {
    @EmbeddedId
    @AttributeOverrides({
            @AttributeOverride(name = "showIdentifier", column = @Column(name = "show_identifier", length = 36, columnDefinition = "UUID")),
            @AttributeOverride(name = "languageIdentifier", column = @Column(name = "language_identifier", length = 36, columnDefinition = "UUID"))
    })
    private ShowsLanguagesId id;

    public ShowsLanguages() {
    }

    public ShowsLanguages(ShowsLanguagesId id) {
        this.id = id;
    }

    public ShowsLanguagesId getId() {
        return id;
    }

    public void setId(ShowsLanguagesId id) {
        this.id = id;
    }

    public UUID getShowIdentifier() {
        return this.id.getShowIdentifier();
    }

    public UUID getLanguageIdentifier() {
        return this.id.getLanguageIdentifier();
    }
}