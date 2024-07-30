package com.cinelist.ms.cast.controllers.search;

import com.cinelist.ms.cast.database.models.Cast;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

import java.util.UUID;

public interface CastSearchController {
    ResponseEntity<Cast> findByIdentifier(UUID identifier);
    ResponseEntity<Page<Cast>> findByName(String name, Pageable pageable);
}