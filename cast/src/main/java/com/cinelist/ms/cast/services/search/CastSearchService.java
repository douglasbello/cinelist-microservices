package com.cinelist.ms.cast.services.search;

import com.cinelist.ms.cast.database.models.Cast;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.UUID;

public interface CastSearchService {
    Cast findByIdentifier(UUID identifier);
    Page<Cast> findByName(String name, Pageable pageable);
}