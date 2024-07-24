package com.cinelist.ms.catalog.services.update;

import java.util.UUID;

public interface MovieUpdateService {
    void addGenreToMovie(UUID genreIdentifier, UUID movieIdentifier);
    void addPlatformToMovie(UUID platformIdentifier, UUID movieIdentifier);
}