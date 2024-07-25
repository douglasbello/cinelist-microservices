package com.cinelist.ms.catalog.services.register;

import com.cinelist.ms.catalog.database.models.Language;
import com.cinelist.ms.catalog.dtos.languages.LanguageRequest;

public interface LanguageRegisterService {
    Language register(LanguageRequest request);
}