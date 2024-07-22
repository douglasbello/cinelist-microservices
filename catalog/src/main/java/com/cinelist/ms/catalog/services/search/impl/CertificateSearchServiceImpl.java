package com.cinelist.ms.catalog.services.search.impl;

import com.cinelist.ms.catalog.database.models.Certificate;
import com.cinelist.ms.catalog.database.repositories.CertificateRepository;
import com.cinelist.ms.catalog.handlers.exceptions.ResourceNotFoundException;
import com.cinelist.ms.catalog.services.search.CertificateSearchService;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class CertificateSearchServiceImpl implements CertificateSearchService {
    private final CertificateRepository certificateRepository;

    public CertificateSearchServiceImpl(CertificateRepository certificateRepository) {
        this.certificateRepository = certificateRepository;
    }

    @Override
    public Certificate findByIdentifier(UUID identifier) {
        return certificateRepository.findById(identifier).orElseThrow(() -> new ResourceNotFoundException(identifier.toString()));
    }

    @Override
    public boolean exists(UUID identifier) {
        if (identifier == null)
            return false;

        Optional<Certificate> certificate = certificateRepository.findById(identifier);

        return certificate.isPresent();
    }
}
