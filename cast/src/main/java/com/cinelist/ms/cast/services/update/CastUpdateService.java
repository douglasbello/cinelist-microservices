package com.cinelist.ms.cast.services.update;

import java.util.UUID;

public interface CastUpdateService {
    void addMovieToCast(UUID castIdentifier, UUID movieIdentifier);
}