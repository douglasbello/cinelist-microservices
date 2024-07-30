package com.cinelist.ms.cast.controllers.search.impl;

import com.cinelist.ms.cast.controllers.search.OccupationSearchController;
import com.cinelist.ms.cast.database.models.Occupation;
import com.cinelist.ms.cast.services.search.OccupationSearchService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/occupations")
public class OccupationSearchControllerImpl implements OccupationSearchController {
    private final OccupationSearchService occupationSearchService;

    public OccupationSearchControllerImpl(OccupationSearchService occupationSearchService) {
        this.occupationSearchService = occupationSearchService;
    }

    @GetMapping("/{identifier}")
    public ResponseEntity<Occupation> findByIdentifier(@PathVariable UUID identifier) {
        return ResponseEntity.ok().body(occupationSearchService.findByIdentifier(identifier));
    }

    @GetMapping
    public ResponseEntity<List<Occupation>> findAll() {
        return ResponseEntity.ok().body(occupationSearchService.findAll());
    }
}