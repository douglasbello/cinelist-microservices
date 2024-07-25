package com.cinelist.ms.catalog.controllers.search.impl;

import com.cinelist.ms.catalog.controllers.search.LanguageSearchController;
import com.cinelist.ms.catalog.database.models.Language;
import com.cinelist.ms.catalog.services.search.LanguageSearchService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/languages")
public class LanguageSearchControllerImpl implements LanguageSearchController {
    private final LanguageSearchService languageSearchService;

    public LanguageSearchControllerImpl(LanguageSearchService languageSearchService) {
        this.languageSearchService = languageSearchService;
    }

    @GetMapping("/{identifier}")
    public ResponseEntity<Language> findByIdentifier(@PathVariable UUID identifier) {
        return ResponseEntity.ok().body(languageSearchService.findByIdentifier(identifier));
    }

    @GetMapping
    public ResponseEntity<Page<Language>> findAll(@RequestParam(required = false) String name, Pageable pageable) {
        return ResponseEntity.ok().body(languageSearchService.findAll(name, pageable));
    }
}