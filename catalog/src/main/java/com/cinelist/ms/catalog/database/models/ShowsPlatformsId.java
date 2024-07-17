package com.cinelist.ms.catalog.database.models;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class ShowsPlatformsId {
    @Column(name = "show_identifier", length = 36)
    private String showIdentifier;
    @Column(name = "platform_identifier", length = 36)
    private String platformIdentifier;

    public ShowsPlatformsId() {
    }

    public ShowsPlatformsId(String showIdentifier, String platformIdentifier) {
        this.showIdentifier = showIdentifier;
        this.platformIdentifier = platformIdentifier;
    }

    public String getShowIdentifier() {
        return showIdentifier;
    }

    public void setShowIdentifier(String showIdentifier) {
        this.showIdentifier = showIdentifier;
    }

    public String getPlatformIdentifier() {
        return platformIdentifier;
    }

    public void setPlatformIdentifier(String platformIdentifier) {
        this.platformIdentifier = platformIdentifier;
    }
}