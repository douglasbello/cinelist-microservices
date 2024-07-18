package com.cinelist.ms.catalog.database.models;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(name = "tb_movies_platforms")
public class MoviesPlatforms {
    @EmbeddedId
    @AttributeOverrides({
            @AttributeOverride(name = "movieIdentifier", column = @Column(name = "movie_identifier", length = 36)),
            @AttributeOverride(name = "platformIdentifier", column = @Column(name = "platform_identifier", length = 36))
    })
    private MoviesPlatformsId id;
    @CreationTimestamp
    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    public MoviesPlatforms() {
    }

    public MoviesPlatforms(MoviesPlatformsId id) {
        this.id = id;
    }

    public MoviesPlatformsId getId() {
        return id;
    }

    public void setId(MoviesPlatformsId id) {
        this.id = id;
    }

    public String getMovieIdentifier() {
        return this.id.getMovieIdentifier();
    }

    public String getPlatformIdentifier() {
        return this.id.getPlatformIdentifier();
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}