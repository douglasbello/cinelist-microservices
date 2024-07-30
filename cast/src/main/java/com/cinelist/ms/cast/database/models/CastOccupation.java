package com.cinelist.ms.cast.database.models;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "tb_cast_occupation")
public class CastOccupation {
    @EmbeddedId
    @AttributeOverrides({
            @AttributeOverride(name = "cast_identifier", column = @Column(name = "cast_identifier", length = 36, columnDefinition = "UUID")),
            @AttributeOverride(name = "occupation_identifier", column = @Column(name = "occupation_identifier", length = 36, columnDefinition = "UUID"))
    })
    private CastOccupationId id;
    @CreationTimestamp
    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    public CastOccupation() {
    }

    public CastOccupation(CastOccupationId id) {
        this.id = id;
    }

    public CastOccupation(UUID castIdentifier, UUID occupationIdentifier) {
        this.id = new CastOccupationId(castIdentifier, occupationIdentifier);
    }

    public UUID getCastIdentifier() {
        return this.id.getCastIdentifier();
    }

    public UUID getOccupationIdentifier() {
        return this.id.getOccupationIdentifier();
    }

    public CastOccupationId getId() {
        return id;
    }

    public void setId(CastOccupationId id) {
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