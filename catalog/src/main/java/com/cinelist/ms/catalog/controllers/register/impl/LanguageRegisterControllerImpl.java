package com.cinelist.ms.catalog.controllers.register.impl;

import com.cinelist.ms.catalog.controllers.register.LanguageRegisterController;
import com.cinelist.ms.catalog.database.models.Language;
import com.cinelist.ms.catalog.dtos.languages.LanguageRequest;
import com.cinelist.ms.catalog.services.register.LanguageRegisterService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/languages")
public class LanguageRegisterControllerImpl implements LanguageRegisterController {
    private final LanguageRegisterService languageRegisterService;

    public LanguageRegisterControllerImpl(LanguageRegisterService languageRegisterService) {
        this.languageRegisterService = languageRegisterService;
    }

    @PostMapping
    public ResponseEntity<Language> register(LanguageRequest request) {
        Language created = languageRegisterService.register(request);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{identifier}").buildAndExpand(created.getIdentifier()).toUri();

        return ResponseEntity.created(uri).body(created);
    }
}