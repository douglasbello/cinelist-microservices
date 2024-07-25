package com.cinelist.ms.catalog.services.search;

import com.cinelist.ms.catalog.database.models.Language;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.UUID;

public interface LanguageSearchService {
    Language findByIdentifier(UUID identifier);
    Page<Language> findAll(String name, Pageable pageable);
}