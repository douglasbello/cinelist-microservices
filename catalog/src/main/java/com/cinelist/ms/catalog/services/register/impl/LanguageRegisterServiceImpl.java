package com.cinelist.ms.catalog.services.register.impl;

import com.cinelist.ms.catalog.database.models.Language;
import com.cinelist.ms.catalog.database.repositories.LanguageRepository;
import com.cinelist.ms.catalog.dtos.languages.LanguageRequest;
import com.cinelist.ms.catalog.services.register.LanguageRegisterService;
import org.springframework.stereotype.Service;

@Service
public class LanguageRegisterServiceImpl implements LanguageRegisterService {
    private LanguageRepository languageRepository;

    public LanguageRegisterServiceImpl(LanguageRepository languageRepository) {
        this.languageRepository = languageRepository;
    }

    @Override
    public Language register(LanguageRequest request) {
        Language language = new Language(request.name());

        return languageRepository.save(language);
    }
}