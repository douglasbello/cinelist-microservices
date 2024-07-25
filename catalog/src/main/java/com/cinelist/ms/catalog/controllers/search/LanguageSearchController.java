package com.cinelist.ms.catalog.controllers.search;

import com.cinelist.ms.catalog.database.models.Language;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

import java.util.UUID;

public interface LanguageSearchController {
    ResponseEntity<Language> findByIdentifier(UUID identifier);
    ResponseEntity<Page<Language>> findAll(String name, Pageable pageable);
}