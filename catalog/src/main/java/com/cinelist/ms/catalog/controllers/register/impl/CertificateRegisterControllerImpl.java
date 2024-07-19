package com.cinelist.ms.catalog.controllers.register.impl;

import com.cinelist.ms.catalog.controllers.register.CertificateRegisterController;
import com.cinelist.ms.catalog.database.models.Certificate;
import com.cinelist.ms.catalog.dtos.genres.CertificateRequest;
import com.cinelist.ms.catalog.services.register.CertificateRegisterService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/certificates")
public class CertificateRegisterControllerImpl implements CertificateRegisterController {
    private CertificateRegisterService certificateRegisterService;

    public CertificateRegisterControllerImpl(CertificateRegisterService certificateRegisterService) {
        this.certificateRegisterService = certificateRegisterService;
    }

    @PostMapping
    public ResponseEntity<Certificate> register(@RequestBody CertificateRequest request) {
        return ResponseEntity.ok().body(certificateRegisterService.register(request));
    }
}