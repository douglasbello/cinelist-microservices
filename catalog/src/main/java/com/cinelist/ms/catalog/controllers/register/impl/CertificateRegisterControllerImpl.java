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
    private final CertificateRegisterService certificateRegisterService;

    public CertificateRegisterControllerImpl(CertificateRegisterService certificateRegisterService) {
        this.certificateRegisterService = certificateRegisterService;
    }

    @PostMapping
    public ResponseEntity<Certificate> register(@RequestBody CertificateRequest request) {
        return ResponseEntity.ok().body(certificateRegisterService.register(request));
    }
}