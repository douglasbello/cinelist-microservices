package com.cinelist.ms.cast.controllers.search;

import com.cinelist.ms.cast.database.models.Occupation;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.UUID;

public interface OccupationSearchController {
    ResponseEntity<Occupation> findByIdentifier(UUID identifier);
    ResponseEntity<List<Occupation>> findAll();
}