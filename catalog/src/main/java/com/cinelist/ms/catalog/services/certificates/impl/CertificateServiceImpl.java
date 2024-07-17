package com.cinelist.ms.catalog.services.certificates.impl;

import com.cinelist.ms.catalog.database.models.Certificate;
import com.cinelist.ms.catalog.database.repositories.CertificateRepository;
import com.cinelist.ms.catalog.handlers.exceptions.ResourceNotFound;
import com.cinelist.ms.catalog.services.certificates.CertificateService;
import org.springframework.stereotype.Service;

@Service
public class CertificateServiceImpl implements CertificateService {
    private final CertificateRepository certificateRepository;

    public CertificateServiceImpl(CertificateRepository certificateRepository) {
        this.certificateRepository = certificateRepository;
    }

    @Override
    public Certificate findByIdentifier(String identifier) throws ResourceNotFound {
        return certificateRepository.findById(identifier).orElseThrow(() -> new ResourceNotFound(identifier));
    }

    @Override
    public boolean exists(String identifier) throws ResourceNotFound {
        boolean exists = false;

        Certificate certificate = findByIdentifier(identifier);

        if (certificate != null) {
            exists = true;
        }

        return exists;
    }
}