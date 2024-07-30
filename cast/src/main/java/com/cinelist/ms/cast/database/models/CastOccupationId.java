package com.cinelist.ms.cast.database.models;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.util.UUID;

@Embeddable
public class CastOccupationId {
    @Column(name = "cast_identifier", length = 36)
    private UUID castIdentifier;
    @Column(name = "occupation_identifier", length = 36)
    private UUID occupationIdentifier;

    public CastOccupationId() {
    }

    public CastOccupationId(UUID castIdentifier, UUID occupationIdentifier) {
        this.castIdentifier = castIdentifier;
        this.occupationIdentifier = occupationIdentifier;
    }

    public UUID getCastIdentifier() {
        return castIdentifier;
    }

    public void setCastIdentifier(UUID castIdentifier) {
        this.castIdentifier = castIdentifier;
    }

    public UUID getOccupationIdentifier() {
        return occupationIdentifier;
    }

    public void setOccupationIdentifier(UUID occupationIdentifier) {
        this.occupationIdentifier = occupationIdentifier;
    }
}