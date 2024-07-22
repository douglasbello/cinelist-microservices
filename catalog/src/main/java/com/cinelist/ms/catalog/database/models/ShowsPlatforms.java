package com.cinelist.ms.catalog.database.models;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "tb_shows_platforms")
public class ShowsPlatforms {
    @EmbeddedId
    @AttributeOverrides({
            @AttributeOverride(name = "showIdentifier", column = @Column(name = "show_identifier", length = 36, columnDefinition = "UUID")),
            @AttributeOverride(name = "platformIdentifier", column = @Column(name = "platform_identifier", length = 36, columnDefinition = "UUID"))
    })
    private ShowsPlatformsId id;

    public ShowsPlatforms() {
    }

    public ShowsPlatforms(ShowsPlatformsId id) {
        this.id = id;
    }

    public ShowsPlatformsId getId() {
        return id;
    }

    public void setId(ShowsPlatformsId id) {
        this.id = id;
    }

    public UUID getShowIdentifier() {
        return this.id.getShowIdentifier();
    }

    public UUID getPlatformIdentifier() {
        return this.id.getPlatformIdentifier();
    }
}