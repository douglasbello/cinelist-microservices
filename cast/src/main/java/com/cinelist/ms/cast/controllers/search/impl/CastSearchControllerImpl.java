package com.cinelist.ms.cast.controllers.search.impl;

import com.cinelist.ms.cast.controllers.search.CastSearchController;
import com.cinelist.ms.cast.database.models.Cast;
import com.cinelist.ms.cast.services.search.CastSearchService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/casts")
public class CastSearchControllerImpl implements CastSearchController {
    private final CastSearchService castSearchService;

    public CastSearchControllerImpl(CastSearchService castSearchService) {
        this.castSearchService = castSearchService;
    }

    @GetMapping("/{identifier}")
    public ResponseEntity<Cast> findByIdentifier(@PathVariable UUID identifier) {
        return ResponseEntity.ok().body(castSearchService.findByIdentifier(identifier));
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<Page<Cast>> findByName(@PathVariable String name, Pageable pageable) {
        return ResponseEntity.ok().body(castSearchService.findByName(name, pageable));
    }
}