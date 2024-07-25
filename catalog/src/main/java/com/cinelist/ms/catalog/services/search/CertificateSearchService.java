package com.cinelist.ms.catalog.services.search;

import com.cinelist.ms.catalog.database.models.Certificate;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.UUID;

public interface CertificateSearchService {
    Certificate findByIdentifier(UUID identifier);
    Page<Certificate> findAll(Pageable pageable);
}