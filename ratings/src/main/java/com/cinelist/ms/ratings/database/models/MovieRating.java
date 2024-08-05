package com.cinelist.ms.ratings.database.models;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "tb_movies_ratings")
public class MovieRating {
    @EmbeddedId
    @AttributeOverrides({
            @AttributeOverride(name = "movieIdentifier", column = @Column(name = "movie_identifier", length = 36, columnDefinition = "UUID")),
            @AttributeOverride(name = "ratingIdentifier", column = @Column(name = "rating_identifier", length = 36, columnDefinition = "UUID"))
    })
    private MovieRatingId id;
    @CreationTimestamp
    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    public MovieRating() {
    }

    public MovieRating(MovieRatingId id) {
        this.id = id;
    }

    public MovieRating(UUID movieIdentifier, UUID ratingIdentifier) {
        this.id = new MovieRatingId(movieIdentifier, ratingIdentifier);
    }

    public UUID getMovieIdentifier() {
        return id.getMovieIdentifier();
    }

    public UUID getRatingIdentifier() {
        return id.getRatingIdentifier();
    }

    public MovieRatingId getId() {
        return id;
    }

    public void setId(MovieRatingId id) {
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