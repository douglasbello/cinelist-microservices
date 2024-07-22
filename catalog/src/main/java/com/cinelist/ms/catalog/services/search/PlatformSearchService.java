package com.cinelist.ms.catalog.services.search;

import com.cinelist.ms.catalog.database.models.Platform;

import java.util.UUID;

public interface PlatformSearchService {
    Platform findByIdentifier(UUID identifier);
    Platform findByName(String name);
}