package com.cinelist.ms.catalog.database.models;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_movies_languages")
public class MoviesLanguages {
    @EmbeddedId
    private MoviesLanguagesId id;

    public MoviesLanguages() {
    }

    public MoviesLanguages(MoviesLanguagesId id) {
        this.id = id;
    }
}