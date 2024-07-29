package com.cinelist.ms.cast.database.models;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "tb_cast_show")
public class CastShow {
    @EmbeddedId
    @AttributeOverrides({
            @AttributeOverride(name = "cast_identifier", column = @Column(name = "cast_identifier", length = 36, columnDefinition = "UUID")),
            @AttributeOverride(name = "show_identifier", column = @Column(name = "show_identifier", length = 36, columnDefinition = "UUID"))
    })
    private CastShowId id;
    @CreationTimestamp
    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    public CastShow() {
    }

    public CastShow(CastShowId id) {
        this.id = id;
    }

    public CastShow(UUID castIdentifier, UUID showIdentifier) {
        this.id = new CastShowId(castIdentifier, showIdentifier);
    }

    public UUID getCastIdentifier() {
        return this.id.getCastIdentifier();
    }

    public UUID getShowIdentifier() {
        return this.id.getShowIdentifier();
    }

    public CastShowId getId() {
        return id;
    }

    public void setId(CastShowId id) {
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