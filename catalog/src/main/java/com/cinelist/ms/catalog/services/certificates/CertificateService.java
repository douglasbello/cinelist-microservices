package com.cinelist.ms.catalog.services.certificates;

import com.cinelist.ms.catalog.database.models.Certificate;
import com.cinelist.ms.catalog.handlers.exceptions.ResourceNotFound;

public interface CertificateService {
    Certificate findByIdentifier(String identifier) throws ResourceNotFound;
    boolean exists(String identifier) throws ResourceNotFound;
}