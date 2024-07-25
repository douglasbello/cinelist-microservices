package com.cinelist.ms.catalog.services.register.impl;

import com.cinelist.ms.catalog.database.models.Platform;
import com.cinelist.ms.catalog.database.repositories.PlatformRepository;
import com.cinelist.ms.catalog.dtos.platforms.PlatformRequest;
import com.cinelist.ms.catalog.services.register.PlatformRegisterService;
import org.springframework.stereotype.Service;

@Service
public class PlatformRegisterServiceImpl implements PlatformRegisterService {
    private final PlatformRepository platformRepository;

    public PlatformRegisterServiceImpl(PlatformRepository platformRepository) {
        this.platformRepository = platformRepository;
    }

    @Override
    public Platform register(PlatformRequest request) {
        Platform platform = new Platform(request.name());

        return platformRepository.save(platform);
    }
}