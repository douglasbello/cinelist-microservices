package com.cinelist.ms.catalog.services.search;

import com.cinelist.ms.catalog.database.models.Language;

import java.util.UUID;

public interface LanguageSearchService {
    Language findByIdentifier(UUID identifier);
    Language findByName(String name);
}