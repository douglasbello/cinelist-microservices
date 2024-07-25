package com.cinelist.ms.catalog.controllers.search.impl;

import com.cinelist.ms.catalog.controllers.search.PlatformSearchController;
import com.cinelist.ms.catalog.database.models.Platform;
import com.cinelist.ms.catalog.services.search.PlatformSearchService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/platforms")
public class PlatformSearchControllerImpl implements PlatformSearchController {
    private final PlatformSearchService platformSearchService;

    public PlatformSearchControllerImpl(PlatformSearchService platformSearchService) {
        this.platformSearchService = platformSearchService;
    }

    @GetMapping("/{identifier}")
    public ResponseEntity<Platform> findByIdentifier(@PathVariable UUID identifier) {
        return ResponseEntity.ok().body(platformSearchService.findByIdentifier(identifier));
    }

    @GetMapping
    public ResponseEntity<Page<Platform>> findAll(@RequestParam(required = false) String name, Pageable pageable) {
        return ResponseEntity.ok().body(platformSearchService.findAll(name, pageable));
    }
}