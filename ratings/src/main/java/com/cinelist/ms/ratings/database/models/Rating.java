package com.cinelist.ms.ratings.database.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "tb_ratings")
public class Rating {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "identifier", length = 36, columnDefinition = "UUID")
    private UUID identifier;
    @NotNull(message = "Rate value cannot be null.")
    @Min(value = 0, message = "Rate value cannot be negative.")
    @Max(value = 10, message = "Rate value cannot be bigger than 10.")
    @Column(name = "rate")
    private Double rate;
    @Column(name = "media_identifier", length = 36)
    private UUID mediaIdentifier;
    @Column(name = "user_identifier", length = 36)
    private UUID userIdentifier;
    @CreationTimestamp
    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    public Rating() {
    }

    public Rating(Double rate, UUID mediaIdentifier) {
        this.rate = rate;
        this.mediaIdentifier = mediaIdentifier;
    }

    public Rating(Double rate, UUID mediaIdentifier, UUID userIdentifier) {
        this.rate = rate;
        this.mediaIdentifier = mediaIdentifier;
        this.userIdentifier = userIdentifier;
    }

    public UUID getIdentifier() {
        return identifier;
    }

    public void setIdentifier(UUID identifier) {
        this.identifier = identifier;
    }

    public Double getRate() {
        return rate;
    }

    public void setRate(Double rate) {
        this.rate = rate;
    }

    public UUID getMediaIdentifier() {
        return mediaIdentifier;
    }

    public void setMediaIdentifier(UUID mediaIdentifier) {
        this.mediaIdentifier = mediaIdentifier;
    }

    public UUID getUserIdentifier() {
        return userIdentifier;
    }

    public void setUserIdentifier(UUID userIdentifier) {
        this.userIdentifier = userIdentifier;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Rating rating = (Rating) o;
        return Objects.equals(identifier, rating.identifier);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(identifier);
    }

    @Override
    public String toString() {
        return "Rating{" +
                "identifier=" + identifier +
                ", rate=" + rate +
                ", mediaIdentifier=" + mediaIdentifier +
                ", userIdentifier=" + userIdentifier +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                '}';
    }
}