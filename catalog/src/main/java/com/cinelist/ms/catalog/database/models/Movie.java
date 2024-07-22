package com.cinelist.ms.catalog.database.models;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "tb_movies")
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "identifier", columnDefinition = "UUID")
    private String identifier;
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
    private String certificateIdentifier;
    @Column(name = "duration", length = 15)
    private String duration;

    public Movie() {
    }

    public Movie(MovieBuilder builder) {
        this.title = builder.title;
        this.shortDescription = builder.shortDescription;
        this.longDescription = builder.longDescription;
        this.releaseDate = builder.releaseDate;
        this.trailerUrl = builder.trailerUrl;
        this.thumbnailUrl = builder.thumbnailUrl;
        this.certificateIdentifier = builder.certificateId;
        this.duration = builder.duration;
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

    public void setCertificateIdentifier(String certificateId) {
        this.certificateIdentifier = certificateId;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public static class MovieBuilder {
        private String title;
        private String shortDescription;
        private String longDescription;
        private LocalDate releaseDate;
        private String trailerUrl;
        private String thumbnailUrl;
        private String certificateId;
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

        public MovieBuilder setCertificateId(String certificateId) {
            this.certificateId = certificateId;

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
                "identifier='" + identifier + '\'' +
                ", title='" + title + '\'' +
                ", shortDescription='" + shortDescription + '\'' +
                ", longDescription='" + longDescription + '\'' +
                ", releaseDate=" + releaseDate +
                ", trailerUrl='" + trailerUrl + '\'' +
                ", thumbnailUrl='" + thumbnailUrl + '\'' +
                ", certificateId='" + certificateIdentifier + '\'' +
                ", duration='" + duration + '\'' +
                '}';
    }
}