package com.cinelist.ms.catalog.controllers.search;

import com.cinelist.ms.catalog.database.models.Platform;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

import java.util.UUID;

public interface PlatformSearchController {
    ResponseEntity<Platform> findByIdentifier(UUID identifier);
    ResponseEntity<Page<Platform>> findAll(String name, Pageable pageable);
}