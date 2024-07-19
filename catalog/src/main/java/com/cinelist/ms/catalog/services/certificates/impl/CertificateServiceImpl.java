package com.cinelist.ms.catalog.services.certificates.impl;

import com.cinelist.ms.catalog.database.models.Certificate;
import com.cinelist.ms.catalog.database.repositories.CertificateRepository;
import com.cinelist.ms.catalog.handlers.exceptions.ResourceNotFoundException;
import com.cinelist.ms.catalog.services.certificates.CertificateService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CertificateServiceImpl implements CertificateService {
    private final CertificateRepository certificateRepository;

    public CertificateServiceImpl(CertificateRepository certificateRepository) {
        this.certificateRepository = certificateRepository;
    }

    @Override
    public Certificate findByIdentifier(String identifier) {
        return certificateRepository.findById(identifier).orElseThrow(() -> new ResourceNotFoundException(identifier));
    }

    @Override
    public boolean exists(String identifier) {
        if (identifier == null)
            return false;

        Optional<Certificate> certificate = certificateRepository.findById(identifier);

        return certificate.isPresent();
    }
}