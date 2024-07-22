package com.cinelist.ms.catalog.database.models;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.util.UUID;

@Embeddable
public class ShowsPlatformsId {
    @Column(name = "show_identifier", length = 36)
    private UUID showIdentifier;
    @Column(name = "platform_identifier", length = 36)
    private UUID platformIdentifier;

    public ShowsPlatformsId() {
    }

    public ShowsPlatformsId(UUID showIdentifier, UUID platformIdentifier) {
        this.showIdentifier = showIdentifier;
        this.platformIdentifier = platformIdentifier;
    }

    public UUID getShowIdentifier() {
        return showIdentifier;
    }

    public void setShowIdentifier(UUID showIdentifier) {
        this.showIdentifier = showIdentifier;
    }

    public UUID getPlatformIdentifier() {
        return platformIdentifier;
    }

    public void setPlatformIdentifier(UUID platformIdentifier) {
        this.platformIdentifier = platformIdentifier;
    }
}