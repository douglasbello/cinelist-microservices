package com.cinelist.ms.cast.database.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "tb_cast")
public class Cast {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "identifier", columnDefinition = "UUID", length = 36)
    private UUID identifier;
    @NotEmpty(message = "First name cannot be null or blank.")
    @Column(name = "first_name", length = 70)
    private String firstName;
    @NotEmpty(message = "Last name cannot be null or blank.")
    @Column(name = "last_name", length = 255)
    private String lastName;
    @NotNull(message = "Birth date cannot be null.")
    @Column(name = "birth_date")
    private LocalDate birthDate;
    @Column(name = "photoUrl", length = 255)
    private String photoUrl;
    @CreationTimestamp
    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    public Cast() {
    }

    public Cast(String firstName, String lastName, LocalDate birthDate, String photoUrl) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.photoUrl = photoUrl;
    }

    public UUID getIdentifier() {
        return identifier;
    }

    public void setIdentifier(UUID identifier) {
        this.identifier = identifier;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public String getPhotoUrl() {
        return photoUrl;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cast cast = (Cast) o;
        return Objects.equals(identifier, cast.identifier);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(identifier);
    }

    @Override
    public String toString() {
        return "Cast{" +
                "identifier=" + identifier +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", birthDate=" + birthDate +
                ", photoUrl='" + photoUrl + '\'' +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                '}';
    }
}