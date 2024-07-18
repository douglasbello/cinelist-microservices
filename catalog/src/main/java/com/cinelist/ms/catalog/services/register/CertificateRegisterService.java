package com.cinelist.ms.catalog.services.register;

import com.cinelist.ms.catalog.database.models.Certificate;
import com.cinelist.ms.catalog.dtos.genres.CertificateRequest;

public interface CertificateRegisterService {
    Certificate register(CertificateRequest request);
}