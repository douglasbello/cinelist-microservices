package com.cinelist.ms.cast.services.register;

import com.cinelist.ms.cast.database.models.Occupation;
import com.cinelist.ms.cast.dtos.occupations.OccupationRequest;

public interface OccupationRegisterService {
    Occupation register(OccupationRequest request);
}