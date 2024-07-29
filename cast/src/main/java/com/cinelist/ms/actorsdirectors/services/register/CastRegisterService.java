package com.cinelist.ms.actorsdirectors.services.register;

import com.cinelist.ms.actorsdirectors.database.models.Cast;
import com.cinelist.ms.actorsdirectors.dtos.cast.CastRequest;

public interface CastRegisterService {
    Cast register(CastRequest request);
}