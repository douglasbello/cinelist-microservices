package com.cinelist.ms.cast.services.register;

import com.cinelist.ms.cast.database.models.Cast;
import com.cinelist.ms.cast.dtos.cast.CastRequest;

public interface CastRegisterService {
    Cast register(CastRequest request);
}