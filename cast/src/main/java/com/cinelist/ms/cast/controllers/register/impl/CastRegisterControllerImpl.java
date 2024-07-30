package com.cinelist.ms.cast.controllers.register.impl;

import com.cinelist.ms.cast.client.MoviesClient;
import com.cinelist.ms.cast.controllers.register.CastRegisterController;
import com.cinelist.ms.cast.database.models.Cast;
import com.cinelist.ms.cast.dtos.cast.CastRequest;
import com.cinelist.ms.cast.services.register.CastRegisterService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/casts")
public class CastRegisterControllerImpl implements CastRegisterController {
    private final CastRegisterService castRegisterService;
    private final MoviesClient moviesClient;

    public CastRegisterControllerImpl(CastRegisterService castRegisterService, MoviesClient moviesClient) {
        this.castRegisterService = castRegisterService;
        this.moviesClient = moviesClient;
    }

    @PostMapping
    public ResponseEntity<Cast> register(@RequestBody CastRequest request) {
        Cast created = castRegisterService.register(request);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{identifier}").buildAndExpand(created.getIdentifier()).toUri();

        return ResponseEntity.created(uri).body(created);
    }
}