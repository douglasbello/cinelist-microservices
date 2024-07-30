package com.cinelist.ms.cast.services.search.impl;

import com.cinelist.ms.cast.database.models.Occupation;
import com.cinelist.ms.cast.database.repositories.OccupationRepository;
import com.cinelist.ms.cast.handlers.exceptions.ResourceNotFoundException;
import com.cinelist.ms.cast.services.search.OccupationSearchService;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class OccupationSearchServiceImpl implements OccupationSearchService {
    private final OccupationRepository occupationRepository;

    public OccupationSearchServiceImpl(OccupationRepository occupationRepository) {
        this.occupationRepository = occupationRepository;
    }

    @Override
    public Occupation findByIdentifier(UUID identifier) {
        return occupationRepository.findById(identifier).orElseThrow(() -> new ResourceNotFoundException("Occupation", identifier));
    }

    @Cacheable(cacheNames = "allOccupations")
    @Override
    public List<Occupation> findAll() {
        return occupationRepository.findAll();
    }
}