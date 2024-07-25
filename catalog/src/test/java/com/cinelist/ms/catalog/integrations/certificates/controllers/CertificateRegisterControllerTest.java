package com.cinelist.ms.catalog.integrations.certificates.controllers;

import com.cinelist.ms.catalog.controllers.register.impl.CertificateRegisterControllerImpl;
import com.cinelist.ms.catalog.database.models.Certificate;
import com.cinelist.ms.catalog.dtos.certificates.CertificateRequest;
import com.cinelist.ms.catalog.services.register.impl.CertificateRegisterServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class CertificateRegisterControllerTest {
    @InjectMocks
    private CertificateRegisterControllerImpl certificateRegisterController;

    @Mock
    private CertificateRegisterServiceImpl certificateRegisterService;

    @Test
    void registerMovie() throws Exception {
        CertificateRequest request = new CertificateRequest("16");

        Certificate certificate = new Certificate("16");
        certificate.setIdentifier(UUID.randomUUID());

        MockHttpServletRequest mockReq = new MockHttpServletRequest();
        RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(mockReq));

        when(certificateRegisterService.register(any(CertificateRequest.class))).thenReturn(certificate);

        ResponseEntity<Certificate> responseEntity = certificateRegisterController.register(request);

        int statusCode = responseEntity.getStatusCode().value();
        boolean assertion = statusCode == 200;

        System.out.println(responseEntity);

        assertTrue(assertion);
    }
}