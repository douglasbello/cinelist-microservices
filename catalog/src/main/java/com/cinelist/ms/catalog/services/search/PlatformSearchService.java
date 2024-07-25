package com.cinelist.ms.catalog.services.search;

import com.cinelist.ms.catalog.database.models.Platform;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.UUID;

public interface PlatformSearchService {
    Platform findByIdentifier(UUID identifier);
    Page<Platform> findAll(String name, Pageable pageable);
}