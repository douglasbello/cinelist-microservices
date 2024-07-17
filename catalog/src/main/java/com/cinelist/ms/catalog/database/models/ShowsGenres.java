package com.cinelist.ms.catalog.database.models;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(name = "tb_shows_genres")
public class ShowsGenres {
    @EmbeddedId
    @AttributeOverrides({
            @AttributeOverride(name = "showIdentifier", column = @Column(name = "show_identifier", length = 36)),
            @AttributeOverride(name = "genreIdentifier", column = @Column(name = "genre_identifier", length = 36))
    })
    private ShowsGenresId id;
    @CreationTimestamp
    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    public ShowsGenres() {
    }

    public ShowsGenres(ShowsGenresId id) {
        this.id = id;
    }

    public ShowsGenresId getId() {
        return id;
    }

    public void setId(ShowsGenresId id) {
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