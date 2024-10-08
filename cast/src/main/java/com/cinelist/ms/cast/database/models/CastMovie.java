package com.cinelist.ms.cast.database.models;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "tb_cast_movie")
public class CastMovie {
    @EmbeddedId
    @AttributeOverrides({
            @AttributeOverride(name = "cast_identifier", column = @Column(name = "cast_identifier", length = 36, columnDefinition = "UUID")),
            @AttributeOverride(name = "movie_identifier", column = @Column(name = "movie_identifier", length = 36, columnDefinition = "UUID"))
    })
    private CastMovieId id;
    @CreationTimestamp
    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    public CastMovie() {
    }

    public CastMovie(CastMovieId id) {
        this.id = id;
    }

    public CastMovie(UUID castIdentifier, UUID movieIdentifier) {
        this.id = new CastMovieId(castIdentifier, movieIdentifier);
    }

    public CastMovie(UUID castIdentifier, UUID movieIdentifier, String character) {
        this.id = new CastMovieId(castIdentifier, movieIdentifier, character);
    }

    public UUID getCastIdentifier() {
        return this.id.getCastIdentifier();
    }

    public UUID getMovieIdentifier() {
        return this.id.getMovieIdentifier();
    }

    public String getCharacter() {
        return this.id.getCharacter();
    }

    public CastMovieId getId() {
        return id;
    }

    public void setId(CastMovieId id) {
        this.id = id;
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