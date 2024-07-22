package com.cinelist.ms.catalog.database.models;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "tb_movies_genres")
public class MoviesGenres {
    @EmbeddedId
    @AttributeOverrides({
            @AttributeOverride(name = "movieIdentifier", column = @Column(name = "movie_identifier", length = 36, columnDefinition = "UUID")),
            @AttributeOverride(name = "genreIdentifier", column = @Column(name = "genre_identifier", length = 36, columnDefinition = "UUID"))
    })
    private MoviesGenresId id;
    @CreationTimestamp
    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    public MoviesGenres() {
    }

    public MoviesGenres(MoviesGenresId id) {
        this.id = id;
    }

    public MoviesGenresId getId() {
        return id;
    }

    public void setId(MoviesGenresId id) {
        this.id = id;
    }

    public UUID getGenreIdentifier() {
        return this.id.getGenreIdentifier();
    }

    public UUID getMovieIdentifier() {
        return this.id.getMovieIdentifier();
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