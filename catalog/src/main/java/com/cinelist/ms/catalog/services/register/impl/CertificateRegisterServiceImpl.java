package com.cinelist.ms.catalog.services.register.impl;

import com.cinelist.ms.catalog.database.models.Certificate;
import com.cinelist.ms.catalog.database.repositories.CertificateRepository;
import com.cinelist.ms.catalog.dtos.certificates.CertificateRequest;
import com.cinelist.ms.catalog.services.register.CertificateRegisterService;
import org.springframework.stereotype.Service;

@Service
public class CertificateRegisterServiceImpl implements CertificateRegisterService {
    private final CertificateRepository certificateRepository;

    public CertificateRegisterServiceImpl(CertificateRepository certificateRepository) {
        this.certificateRepository = certificateRepository;
    }

    @Override
    public Certificate register(CertificateRequest request) {
        Certificate certificate = new Certificate(request.age());

        return certificateRepository.save(certificate);
    }
}