package com.cinelist.ms.catalog.controllers.register.impl;

import com.cinelist.ms.catalog.database.models.Platform;
import com.cinelist.ms.catalog.dtos.platforms.PlatformRequest;
import com.cinelist.ms.catalog.services.register.PlatformRegisterService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/platforms")
public class PlatformRegisterControllerImpl {
    private final PlatformRegisterService platformRegisterService;

    public PlatformRegisterControllerImpl(PlatformRegisterService platformRegisterService) {
        this.platformRegisterService = platformRegisterService;
    }

    @PostMapping
    public ResponseEntity<Platform> register(@RequestBody PlatformRequest request) {
        Platform created = platformRegisterService.register(request);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{identifier}").buildAndExpand(created.getIdentifier()).toUri();

        return ResponseEntity.created(uri).body(created);
    }
}