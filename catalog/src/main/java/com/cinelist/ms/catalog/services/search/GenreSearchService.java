package com.cinelist.ms.catalog.services.search;

import com.cinelist.ms.catalog.database.models.Genre;

import java.util.UUID;

public interface GenreSearchService {
    Genre findByIdentifier(UUID identifier);
    Genre findByName(String name);
}