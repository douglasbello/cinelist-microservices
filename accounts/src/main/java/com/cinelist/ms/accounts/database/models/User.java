package com.cinelist.ms.accounts.database.models;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "tb_users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "identifier", length = 36)
    private String identifier;
    @Column(name = "first_name", length = 255)
    private String firstName;
    @Column(name = "last_name", length = 255)
    private String lastName;
    @Column(name = "username", length = 20)
    private String username;
    @Column(name = "email", length = 255)
    private String email;
    @Column(name = "password", length = 255)
    private String password;
    @Column(name = "biography", length = 255)
    private String biography;
    @Column(name = "location", length = 255)
    private String location;
    @Column(name = "photo_url", length = 36)
    private String photoUrl;
    @Column(name = "birth_date")
    private LocalDate birthDate;
    @Column(name = "created_at")
    private LocalDateTime createdAt;
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    public User() {
    }

    public User(UserBuilder builder) {
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.username = builder.username;
        this.email = builder.email;
        this.password = builder.password;
        this.biography = builder.biography;
        this.location = builder.location;
        this.photoUrl = builder.photoUrl;
        this.birthDate = builder.birthDate;
    }

    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
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

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getBiography() {
        return biography;
    }

    public void setBiography(String biography) {
        this.biography = biography;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(identifier, user.identifier);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(identifier);
    }

    @Override
    public String toString() {
        return "User{" +
                "identifier='" + identifier + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", biography='" + biography + '\'' +
                ", location='" + location + '\'' +
                ", photoUrl='" + photoUrl + '\'' +
                ", birthDate=" + birthDate +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                '}';
    }

    public static class UserBuilder {
        private String firstName;
        private String lastName;
        private String username;
        private String email;
        private String password;
        private String biography;
        private String location;
        private String photoUrl;
        private LocalDate birthDate;

        public UserBuilder setFirstName(String firstName) {
            this.firstName = firstName;

            return this;
        }

        public UserBuilder setLastName(String lastName) {
            this.lastName = lastName;

            return this;
        }

        public UserBuilder setUsername(String username) {
            this.username = username;

            return this;
        }

        public UserBuilder setEmail(String email) {
            this.email = email;

            return this;
        }

        public UserBuilder setPassword(String password) {
            this.password = password;

            return this;
        }

        public UserBuilder setBiography(String biography) {
            this.biography = biography;

            return this;
        }

        public UserBuilder setLocation(String location) {
            this.location = location;

            return this;
        }

        public UserBuilder setPhotoUrl(String photoUrl) {
            this.photoUrl = photoUrl;

            return this;
        }

        public UserBuilder setBirthDate(LocalDate birthDate) {
            this.birthDate = birthDate;

            return this;
        }

        public User build() {
            return new User(this);
        }
    }
}