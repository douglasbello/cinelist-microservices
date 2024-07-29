package com.cinelist.ms.actorsdirectors.services.register;

import com.cinelist.ms.actorsdirectors.database.models.Occupation;
import com.cinelist.ms.actorsdirectors.dtos.occupations.OccupationRequest;

public interface OccupationRegisterService {
    Occupation register(OccupationRequest request);
}