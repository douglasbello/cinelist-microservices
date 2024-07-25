package com.cinelist.ms.catalog.services.search.impl;

import com.cinelist.ms.catalog.database.models.Language;
import com.cinelist.ms.catalog.database.repositories.LanguageRepository;
import com.cinelist.ms.catalog.handlers.exceptions.ResourceNotFoundException;
import com.cinelist.ms.catalog.services.search.LanguageSearchService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class LanguageSearchServiceImpl implements LanguageSearchService {
    private final LanguageRepository languageRepository;

    public LanguageSearchServiceImpl(LanguageRepository languageRepository) {
        this.languageRepository = languageRepository;
    }

    @Override
    public Language findByIdentifier(UUID identifier) {
        return languageRepository.findById(identifier).orElseThrow(() -> new ResourceNotFoundException("Language", identifier.toString()));
    }

    @Override
    public Page<Language> findAll(String name, Pageable pageable) {
        if (name != null)
            return languageRepository.findAllByName(name, pageable);

        return languageRepository.findAll(pageable);
    }
}