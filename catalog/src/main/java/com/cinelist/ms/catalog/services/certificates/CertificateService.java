package com.cinelist.ms.catalog.services.certificates;

import com.cinelist.ms.catalog.database.models.Certificate;
import com.cinelist.ms.catalog.handlers.exceptions.ResourceNotFoundException;

public interface CertificateService {
    Certificate findByIdentifier(String identifier) throws ResourceNotFoundException;
    boolean exists(String identifier) throws ResourceNotFoundException;
}