package com.cinelist.ms.catalog.services.search.impl;

import com.cinelist.ms.catalog.database.models.Certificate;
import com.cinelist.ms.catalog.database.repositories.CertificateRepository;
import com.cinelist.ms.catalog.handlers.exceptions.ResourceNotFoundException;
import com.cinelist.ms.catalog.services.search.CertificateSearchService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
        return certificateRepository.findById(identifier).orElseThrow(() -> new ResourceNotFoundException("Certificate", identifier.toString()));
    }

    @Override
    public Page<Certificate> findAll(Pageable pageable) {
        return certificateRepository.findAll(pageable);
    }
}
