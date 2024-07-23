package com.cinelist.ms.catalog.integrations.certificates.services;

import com.cinelist.ms.catalog.database.models.Certificate;
import com.cinelist.ms.catalog.database.repositories.CertificateRepository;
import com.cinelist.ms.catalog.dtos.genres.CertificateRequest;
import com.cinelist.ms.catalog.handlers.exceptions.ResourceNotFoundException;
import com.cinelist.ms.catalog.services.register.impl.CertificateRegisterServiceImpl;
import com.cinelist.ms.catalog.services.search.impl.CertificateSearchServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@SpringBootTest
public class CertificateServicesTest {

    @InjectMocks
    private CertificateRegisterServiceImpl certificateRegisterService;

    @InjectMocks
    private CertificateSearchServiceImpl certificateSearchService;

    @Mock
    private CertificateRepository certificateRepository;

    private Certificate certificate;

    private Certificate certificateRegister;

    private CertificateRequest request;

    private static final UUID certificateId = UUID.randomUUID();

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(CertificateServicesTest.class);
        request = new CertificateRequest("12");

        certificateRegister = new Certificate();
        certificateRegister.setIdentifier(UUID.randomUUID());
        certificateRegister.setAge("12");

        certificate = new Certificate();
        certificate.setIdentifier(certificateId);
        certificate.setAge("12");
    }

    @DisplayName("JUnit test for save certificate operation")
    @Test
    void givenCertificateRequest_whenSave_thenReturnSaveCertificate() {
        when(certificateRepository.save(any(Certificate.class))).thenReturn(certificateRegister);

        Certificate savedCertificate = certificateRegisterService.register(request);

        assertNotNull(savedCertificate);
        assertEquals("12", savedCertificate.getAge());
    }

    @DisplayName("JUnit test for find by non-existing identifier operation")
    @Test
    void givenNonExistingIdentifier_whenFindByIdentifier_thenThrowResourceNotFoundException() {
        UUID identifier = UUID.randomUUID();
        when(certificateRepository.findById(identifier)).thenReturn(Optional.empty());

        assertThrows(ResourceNotFoundException.class, () -> {
            certificateSearchService.findByIdentifier(identifier);
        });
    }
}