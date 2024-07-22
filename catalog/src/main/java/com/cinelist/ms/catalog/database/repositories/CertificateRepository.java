package com.cinelist.ms.catalog.database.repositories;

import com.cinelist.ms.catalog.database.models.Certificate;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CertificateRepository extends JpaRepository<Certificate, UUID> {
}