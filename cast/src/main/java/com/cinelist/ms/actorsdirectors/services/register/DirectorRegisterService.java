package com.cinelist.ms.actorsdirectors.services.register;

import com.cinelist.ms.actorsdirectors.database.models.Director;
import com.cinelist.ms.actorsdirectors.dtos.directors.DirectorRequest;

public interface DirectorRegisterService {
    Director register(DirectorRequest request);
}