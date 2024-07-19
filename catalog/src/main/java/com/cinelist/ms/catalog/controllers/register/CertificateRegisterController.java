package com.cinelist.ms.catalog.controllers.register;

import com.cinelist.ms.catalog.database.models.Certificate;
import com.cinelist.ms.catalog.dtos.genres.CertificateRequest;
import org.springframework.http.ResponseEntity;

public interface CertificateRegisterController {
    ResponseEntity<Certificate> register(CertificateRequest request);
}