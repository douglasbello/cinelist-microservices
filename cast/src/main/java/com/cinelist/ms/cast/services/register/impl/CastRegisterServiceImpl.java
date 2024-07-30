package com.cinelist.ms.cast.services.register.impl;

import com.cinelist.ms.cast.database.models.Cast;
import com.cinelist.ms.cast.database.repositories.CastRepository;
import com.cinelist.ms.cast.dtos.cast.CastRequest;
import com.cinelist.ms.cast.services.register.CastRegisterService;
import com.cinelist.ms.cast.services.update.CastUpdateService;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class CastRegisterServiceImpl implements CastRegisterService {
    private final CastRepository castRepository;
    private final CastUpdateService castUpdateService;

    public CastRegisterServiceImpl(CastRepository castRepository, CastUpdateService castUpdateService) {
        this.castRepository = castRepository;
        this.castUpdateService = castUpdateService;
    }

    @CacheEvict(cacheNames = "allOccupations", allEntries = true)
    @Override
    public Cast register(CastRequest request) {
        Cast cast = new Cast(request.firstName(), request.lastName(), request.birthDate(), request.photoUrl());
        cast = castRepository.save(cast);

        UUID castIdentifier = cast.getIdentifier();

        if (request.occupationIdentifiers() != null)
            request.occupationIdentifiers().forEach(movieIdentifier -> castUpdateService.addOccupationToCast(castIdentifier, movieIdentifier));

        return cast;
    }
}