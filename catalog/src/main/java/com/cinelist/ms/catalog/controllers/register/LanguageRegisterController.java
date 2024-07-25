package com.cinelist.ms.catalog.controllers.register;

import com.cinelist.ms.catalog.database.models.Language;
import com.cinelist.ms.catalog.dtos.languages.LanguageRequest;
import org.springframework.http.ResponseEntity;

public interface LanguageRegisterController {
    ResponseEntity<Language> register(LanguageRequest request);
}