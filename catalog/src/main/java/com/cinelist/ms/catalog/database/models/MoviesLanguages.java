package com.cinelist.ms.catalog.database.models;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(name = "tb_movies_languages")
public class MoviesLanguages {
    @EmbeddedId
    @AttributeOverrides({
            @AttributeOverride(name = "movieIdentifier", column = @Column(name = "movie_identifier", length = 36, columnDefinition = "UUID")),
            @AttributeOverride(name = "languageIdentifier", column = @Column(name = "language_identifier", length = 36, columnDefinition = "UUID"))
    })
    private MoviesLanguagesId id;
    @CreationTimestamp
    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    public MoviesLanguages() {
    }

    public MoviesLanguages(MoviesLanguagesId id) {
        this.id = id;
    }

    public MoviesLanguagesId getId() {
        return id;
    }

    public void setId(MoviesLanguagesId id) {
        this.id = id;
    }

    public String getMovieIdentifier() {
        return this.id.getMovieIdentifier();
    }

    public String getLanguageIdentifier() {
        return this.id.getLanguageIdentifier();
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }
}