package com.cinelist.ms.catalog.database.models;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "tb_seasons")
public class Season {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "identifier", length = 36, columnDefinition = "UUID")
    private UUID identifier;
    @Column(name = "season")
    private Integer season;
    @Column(name = "episodes")
    private Integer episodes;
    @Column(name = "showIdentifier", length = 36, columnDefinition = "UUID")
    private UUID showIdentifier;
    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    public Season() {
    }

    public Season(Integer season, Integer episodes, UUID showIdentifier) {
        this.season = season;
        this.episodes = episodes;
        this.showIdentifier = showIdentifier;
    }

    public UUID getIdentifier() {
        return identifier;
    }

    public void setIdentifier(UUID identifier) {
        this.identifier = identifier;
    }

    public Integer getSeason() {
        return season;
    }

    public void setSeason(Integer season) {
        this.season = season;
    }

    public Integer getEpisodes() {
        return episodes;
    }

    public void setEpisodes(Integer episodes) {
        this.episodes = episodes;
    }

    public UUID getShowIdentifier() {
        return showIdentifier;
    }

    public void setShowIdentifier(UUID showIdentifier) {
        this.showIdentifier = showIdentifier;
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
        Season season = (Season) o;
        return Objects.equals(identifier, season.identifier);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(identifier);
    }

    @Override
    public String toString() {
        return "Season{" +
                "identifier='" + identifier + '\'' +
                ", season=" + season +
                ", episodes=" + episodes +
                ", showIdentifier='" + showIdentifier + '\'' +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                '}';
    }
}