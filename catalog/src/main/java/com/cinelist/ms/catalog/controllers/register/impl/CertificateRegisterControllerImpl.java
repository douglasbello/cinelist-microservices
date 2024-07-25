package com.cinelist.ms.catalog.controllers.register.impl;

import com.cinelist.ms.catalog.controllers.register.CertificateRegisterController;
import com.cinelist.ms.catalog.database.models.Certificate;
import com.cinelist.ms.catalog.dtos.certificates.CertificateRequest;
import com.cinelist.ms.catalog.services.register.CertificateRegisterService;
import com.cinelist.ms.catalog.services.search.CertificateSearchService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/certificates")
public class CertificateRegisterControllerImpl implements CertificateRegisterController {
    private CertificateRegisterService certificateRegisterService;
    private CertificateSearchService certificateSearchService;

    public CertificateRegisterControllerImpl(CertificateRegisterService certificateRegisterService, CertificateSearchService certificateSearchService) {
        this.certificateRegisterService = certificateRegisterService;
        this.certificateSearchService = certificateSearchService;
    }

    @PostMapping
    public ResponseEntity<Certificate> register(@RequestBody CertificateRequest request) {
        return ResponseEntity.ok().body(certificateRegisterService.register(request));
    }

    @GetMapping("/{identifier}")
    public ResponseEntity<Certificate> findByIdentifier(@PathVariable UUID identifier) {
        return ResponseEntity.ok().body(certificateSearchService.findByIdentifier(identifier));
    }
}