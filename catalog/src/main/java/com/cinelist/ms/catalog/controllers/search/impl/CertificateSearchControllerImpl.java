package com.cinelist.ms.catalog.controllers.search.impl;

import com.cinelist.ms.catalog.controllers.search.CertificateSearchController;
import com.cinelist.ms.catalog.database.models.Certificate;
import com.cinelist.ms.catalog.services.search.CertificateSearchService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/certificates")
public class CertificateSearchControllerImpl implements CertificateSearchController{
    private final CertificateSearchService certificateSearchService;

    public CertificateSearchControllerImpl(CertificateSearchService certificateSearchService) {
        this.certificateSearchService = certificateSearchService;
    }

    @GetMapping("/{identifier}")
    public ResponseEntity<Certificate> findByIdentifier(@PathVariable UUID identifier) {
        return ResponseEntity.ok().body(certificateSearchService.findByIdentifier(identifier));
    }

    @GetMapping
    public ResponseEntity<Page<Certificate>> findAll(Pageable pageable) {
        return ResponseEntity.ok().body(certificateSearchService.findAll(pageable));
    }
}