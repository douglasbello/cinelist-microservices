package com.cinelist.ms.catalog.services.register;

import com.cinelist.ms.catalog.database.models.Platform;
import com.cinelist.ms.catalog.dtos.platforms.PlatformRequest;

public interface PlatformRegisterService {
    Platform register(PlatformRequest request);
}