package com.cinelist.ms.catalog.services.certificates;

import com.cinelist.ms.catalog.database.models.Certificate;

public interface CertificateService {
    Certificate findByIdentifier(String identifier);
    boolean exists(String identifier);
}