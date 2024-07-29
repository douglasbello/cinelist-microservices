package com.cinelist.ms.cast.controllers.register.impl;

import com.cinelist.ms.cast.controllers.register.CastRegisterController;
import com.cinelist.ms.cast.database.models.Cast;
import com.cinelist.ms.cast.dtos.cast.CastRequest;
import com.cinelist.ms.cast.services.register.CastRegisterService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/casts")
public class CastRegisterControllerImpl implements CastRegisterController {
    private final CastRegisterService castRegisterService;

    public CastRegisterControllerImpl(CastRegisterService castRegisterService) {
        this.castRegisterService = castRegisterService;
    }

    @PostMapping
    public ResponseEntity<Cast> register(@RequestBody CastRequest request) {
        Cast created = castRegisterService.register(request);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{identifier}").buildAndExpand(created.getIdentifier()).toUri();

        return ResponseEntity.created(uri).body(created);
    }
}