package com.cinelist.ms.catalog.controllers.search;

import com.cinelist.ms.catalog.database.models.Certificate;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

import java.util.UUID;

public interface CertificateSearchController {
    ResponseEntity<Certificate> findByIdentifier(UUID identifier);
    ResponseEntity<Page<Certificate>> findAll(Pageable pageable);
}