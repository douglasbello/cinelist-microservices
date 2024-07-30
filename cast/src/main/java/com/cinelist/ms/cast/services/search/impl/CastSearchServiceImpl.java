package com.cinelist.ms.cast.services.search.impl;

import com.cinelist.ms.cast.database.models.Cast;
import com.cinelist.ms.cast.database.repositories.CastRepository;
import com.cinelist.ms.cast.handlers.exceptions.ResourceNotFoundException;
import com.cinelist.ms.cast.services.search.CastSearchService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class CastSearchServiceImpl implements CastSearchService {
    private final CastRepository castRepository;

    public CastSearchServiceImpl(CastRepository castRepository) {
        this.castRepository = castRepository;
    }

    @Override
    public Cast findByIdentifier(UUID identifier) {
        return castRepository.findById(identifier).orElseThrow(() -> new ResourceNotFoundException("Cast", identifier));
    }

    @Override
    public Page<Cast> findByName(String name, Pageable pageable) {
        return castRepository.findByName(name, pageable);
    }
}