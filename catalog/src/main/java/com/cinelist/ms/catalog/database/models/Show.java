package com.cinelist.ms.catalog.database.models;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "tb_shows")
public class Show {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "identifier", length = 36)
    private String identifier;
    @Column(name = "title", length = 255)
    private String title;
    @Column(name = "short_description", length = 255)
    private String shortDescription;
    @Column(name = "long_description", columnDefinition = "text")
    private String longDescription;
    @Column(name = "release_date")
    private LocalDate releaseDate;
    @Column(name = "trailer_url", length = 255)
    private String trailerUrl;
    @Column(name = "thumbnail_url", length = 255)
    private String thumbnailUrl;
    @Column(name = "certificate_identifier", length = 36)
    private String certificateIdentifier;
    @CreationTimestamp
    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    public Show() {
    }

    public Show(ShowBuilder builder) {
        this.title = builder.title;
        this.shortDescription = builder.shortDescription;
        this.longDescription = builder.longDescription;
        this.releaseDate = builder.releaseDate;
        this.trailerUrl = builder.trailerUrl;
        this.thumbnailUrl = builder.thumbnailUrl;
        this.certificateIdentifier = builder.certificateIdentifier;
    }

    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    public String getLongDescription() {
        return longDescription;
    }

    public void setLongDescription(String longDescription) {
        this.longDescription = longDescription;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getTrailerUrl() {
        return trailerUrl;
    }

    public void setTrailerUrl(String trailerUrl) {
        this.trailerUrl = trailerUrl;
    }

    public String getThumbnailUrl() {
        return thumbnailUrl;
    }

    public void setThumbnailUrl(String thumbnailUrl) {
        this.thumbnailUrl = thumbnailUrl;
    }

    public String getCertificateIdentifier() {
        return certificateIdentifier;
    }

    public void setCertificateIdentifier(String certificateIdentifier) {
        this.certificateIdentifier = certificateIdentifier;
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

    public static class ShowBuilder {
        private String title;
        private String shortDescription;
        private String longDescription;
        private LocalDate releaseDate;
        private String thumbnailUrl;
        private String trailerUrl;
        private String certificateIdentifier;

        public ShowBuilder setTitle(String title) {
            this.title = title;

            return this;
        }

        public ShowBuilder setShortDescription(String shortDescription) {
            this.shortDescription = shortDescription;

            return this;
        }

        public ShowBuilder setLongDescription(String longDescription) {
            this.longDescription = longDescription;

            return this;
        }

        public ShowBuilder setReleaseDate(LocalDate releaseDate) {
            this.releaseDate = releaseDate;

            return this;
        }

        public ShowBuilder setThumbnailUrl(String thumbnailUrl) {
            this.thumbnailUrl = thumbnailUrl;

            return this;
        }

        public ShowBuilder setTrailerUrl(String trailerUrl) {
            this.trailerUrl = trailerUrl;

            return this;
        }

        public ShowBuilder setCertificateIdentifier(String certificateIdentifier) {
            this.certificateIdentifier = certificateIdentifier;

            return this;
        }

        public Show build() {
            return new Show(this);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Show show = (Show) o;
        return Objects.equals(identifier, show.identifier);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(identifier);
    }

    @Override
    public String toString() {
        return "Show{" +
                "identifier='" + identifier + '\'' +
                ", title='" + title + '\'' +
                ", shortDescription='" + shortDescription + '\'' +
                ", longDescription='" + longDescription + '\'' +
                ", releaseDate=" + releaseDate +
                ", trailerUrl='" + trailerUrl + '\'' +
                ", thumbnailUrl='" + thumbnailUrl + '\'' +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                '}';
    }
}