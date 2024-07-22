package com.cinelist.ms.catalog.services.search;

import com.cinelist.ms.catalog.database.models.Certificate;

import java.util.UUID;

public interface CertificateSearchService {
    Certificate findByIdentifier(UUID identifier);
    boolean exists(UUID identifier);
}