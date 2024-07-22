package com.cinelist.ms.catalog.services.search.impl;

import com.cinelist.ms.catalog.database.models.Platform;
import com.cinelist.ms.catalog.database.repositories.PlatformRepository;
import com.cinelist.ms.catalog.handlers.exceptions.ResourceNotFoundException;
import com.cinelist.ms.catalog.services.search.PlatformSearchService;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class PlatformSearchServiceImpl implements PlatformSearchService {
    private final PlatformRepository platformRepository;

    public PlatformSearchServiceImpl(PlatformRepository platformRepository) {
        this.platformRepository = platformRepository;
    }

    @Override
    public Platform findByIdentifier(UUID identifier) {
        return platformRepository.findById(identifier).orElseThrow(() -> new ResourceNotFoundException("Platform", identifier.toString()));
    }

    @Override
    public Platform findByName(String name) {
        return platformRepository.findByName(name);
    }
}