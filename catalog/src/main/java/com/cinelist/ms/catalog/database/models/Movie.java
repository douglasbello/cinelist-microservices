package com.cinelist.ms.catalog.database.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "tb_movies")
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "identifier", columnDefinition = "UUID", length = 36)
    private UUID identifier;
    @NotNull(message = "Title cannot be null.")
    @NotBlank(message = "Title cannot be blank.")
    @Column(name = "title", length = 80)
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
    @Column(name = "certificate_identifier", length = 36, columnDefinition = "UUID")
    private UUID certificateIdentifier;
    @Column(name = "language_identifier", length = 36, columnDefinition = "UUID")
    private UUID languageIdentifier;
    @Column(name = "duration", length = 15)
    private String duration;
    @CreationTimestamp
    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    public Movie() {
    }

    public Movie(MovieBuilder builder) {
        this.title = builder.title;
        this.shortDescription = builder.shortDescription;
        this.longDescription = builder.longDescription;
        this.releaseDate = builder.releaseDate;
        this.trailerUrl = builder.trailerUrl;
        this.thumbnailUrl = builder.thumbnailUrl;
        this.certificateIdentifier = builder.certificateIdentifier;
        this.languageIdentifier = builder.languageIdentifier;
        this.duration = builder.duration;
    }

    public UUID getIdentifier() {
        return identifier;
    }

    public void setIdentifier(UUID identifier) {
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

    public UUID getCertificateIdentifier() {
        return certificateIdentifier;
    }

    public void setCertificateIdentifier(UUID certificateId) {
        this.certificateIdentifier = certificateId;
    }

    public UUID getLanguageIdentifier() {
        return languageIdentifier;
    }

    public void setLanguageIdentifier(UUID languageIdentifier) {
        this.languageIdentifier = languageIdentifier;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public static class MovieBuilder {
        private String title;
        private String shortDescription;
        private String longDescription;
        private LocalDate releaseDate;
        private String trailerUrl;
        private String thumbnailUrl;
        private UUID certificateIdentifier;
        private UUID languageIdentifier;
        private String duration;

        public MovieBuilder setTitle(String title) {
            this.title = title;

            return this;
        }

        public MovieBuilder setShortDescription(String shortDescription) {
            this.shortDescription = shortDescription;

            return this;
        }

        public MovieBuilder setLongDescription(String longDescription) {
            this.longDescription = longDescription;

            return this;
        }

        public MovieBuilder setReleaseDate(LocalDate releaseDate) {
            this.releaseDate = releaseDate;

            return this;
        }

        public MovieBuilder setTrailerUrl(String trailerUrl) {
            this.trailerUrl = trailerUrl;

            return this;
        }

        public MovieBuilder setThumbnailUrl(String thumbnailUrl) {
            this.thumbnailUrl = thumbnailUrl;

            return this;
        }

        public MovieBuilder setCertificateIdentifier(UUID certificateIdentifier) {
            this.certificateIdentifier = certificateIdentifier;

            return this;
        }

        public MovieBuilder setLanguageIdentifier(UUID languageIdentifier) {
            this.languageIdentifier = languageIdentifier;

            return this;
        }

        public MovieBuilder setDuration(String duration) {
            this.duration = duration;

            return this;
        }

        public Movie build() {
            return new Movie(this);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Movie movie = (Movie) o;
        return Objects.equals(identifier, movie.identifier);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(identifier);
    }

    @Override
    public String toString() {
        return "Movie{" +
                "identifier=" + identifier +
                ", title='" + title + '\'' +
                ", shortDescription='" + shortDescription + '\'' +
                ", longDescription='" + longDescription + '\'' +
                ", releaseDate=" + releaseDate +
                ", trailerUrl='" + trailerUrl + '\'' +
                ", thumbnailUrl='" + thumbnailUrl + '\'' +
                ", certificateIdentifier=" + certificateIdentifier +
                ", languageIdentifier=" + languageIdentifier +
                ", duration='" + duration + '\'' +
                '}';
    }
}