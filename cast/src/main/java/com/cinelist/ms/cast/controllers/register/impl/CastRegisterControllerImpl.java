package com.cinelist.ms.cast.controllers.register.impl;

import com.cinelist.ms.cast.client.MoviesClient;
import com.cinelist.ms.cast.controllers.register.CastRegisterController;
import com.cinelist.ms.cast.database.models.Cast;
import com.cinelist.ms.cast.dtos.cast.CastRequest;
import com.cinelist.ms.cast.dtos.client.MovieResponse;
import com.cinelist.ms.cast.services.register.CastRegisterService;
import com.cinelist.ms.cast.services.update.CastUpdateService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.UUID;

@RestController
@RequestMapping("/casts")
public class CastRegisterControllerImpl implements CastRegisterController {
    private final CastRegisterService castRegisterService;
    private final CastUpdateService castUpdateService;
    private final MoviesClient moviesClient;

    public CastRegisterControllerImpl(CastRegisterService castRegisterService, CastUpdateService castUpdateService, MoviesClient moviesClient) {
        this.castRegisterService = castRegisterService;
        this.castUpdateService = castUpdateService;
        this.moviesClient = moviesClient;
    }

    @PostMapping
    public ResponseEntity<Cast> register(@RequestBody CastRequest request) {
        Cast created = castRegisterService.register(request);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{identifier}").buildAndExpand(created.getIdentifier()).toUri();

        return ResponseEntity.created(uri).body(created);
    }

    @GetMapping("/{identifier}")
    public ResponseEntity<MovieResponse> testing(@PathVariable UUID identifier) {
        return moviesClient.findByIdentifier(identifier);
    }
}