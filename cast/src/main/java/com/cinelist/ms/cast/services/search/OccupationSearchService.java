package com.cinelist.ms.cast.services.search;

import com.cinelist.ms.cast.database.models.Occupation;

import java.util.List;
import java.util.UUID;

public interface OccupationSearchService {
    Occupation findByIdentifier(UUID identifier);
    List<Occupation> findAll();
}