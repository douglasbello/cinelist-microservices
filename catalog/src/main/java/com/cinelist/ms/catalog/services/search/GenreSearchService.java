package com.cinelist.ms.catalog.services.search;

import com.cinelist.ms.catalog.database.models.Genre;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.UUID;

public interface GenreSearchService {
    Genre findByIdentifier(UUID identifier);
    Genre findByName(String name);
    Page<Genre> findAll(Pageable pageable);
}