package com.cinelist.ms.cast.database.models;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.util.UUID;

@Embeddable
public class CastShowId {
    @Column(name = "cast_identifier", length = 36)
    private UUID castIdentifier;
    @Column(name = "show_identifier", length = 36)
    private UUID showIdentifier;

    public CastShowId() {
    }

    public CastShowId(UUID castIdentifier, UUID showIdentifier) {
        this.castIdentifier = castIdentifier;
        this.showIdentifier = showIdentifier;
    }

    public UUID getCastIdentifier() {
        return castIdentifier;
    }

    public void setCastIdentifier(UUID castIdentifier) {
        this.castIdentifier = castIdentifier;
    }

    public UUID getShowIdentifier() {
        return showIdentifier;
    }

    public void setShowIdentifier(UUID showIdentifier) {
        this.showIdentifier = showIdentifier;
    }
}