package com.cinelist.ms.catalog.database.models;

import jakarta.persistence.*;

@Entity
@Table(name = "tb_shows_platforms")
public class ShowsPlatforms {
    @EmbeddedId
    @AttributeOverrides({
            @AttributeOverride(name = "showIdentifier", column = @Column(name = "show_identifier", length = 36)),
            @AttributeOverride(name = "platformIdentifier", column = @Column(name = "platformIdentifier", length = 36))
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
}