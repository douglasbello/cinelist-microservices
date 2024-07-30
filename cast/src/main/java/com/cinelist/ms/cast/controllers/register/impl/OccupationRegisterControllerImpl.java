package com.cinelist.ms.cast.controllers.register.impl;

import com.cinelist.ms.cast.controllers.register.OccupationRegisterController;
import com.cinelist.ms.cast.database.models.Occupation;
import com.cinelist.ms.cast.dtos.occupations.OccupationRequest;
import com.cinelist.ms.cast.services.register.OccupationRegisterService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/occupations")
public class OccupationRegisterControllerImpl implements OccupationRegisterController {
    private final OccupationRegisterService occupationRegisterService;

    public OccupationRegisterControllerImpl(OccupationRegisterService occupationRegisterService) {
        this.occupationRegisterService = occupationRegisterService;
    }

    @PostMapping
    public ResponseEntity<Occupation> register(@RequestBody OccupationRequest request) {
        Occupation created = occupationRegisterService.register(request);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{identifier}").buildAndExpand(created.getIdentifier()).toUri();

        return ResponseEntity.created(uri).body(created);
    }
}