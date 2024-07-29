package com.cinelist.ms.actorsdirectors.services.register.impl;

import com.cinelist.ms.actorsdirectors.database.models.Cast;
import com.cinelist.ms.actorsdirectors.database.repositories.CastRepository;
import com.cinelist.ms.actorsdirectors.dtos.cast.CastRequest;
import com.cinelist.ms.actorsdirectors.services.register.CastRegisterService;
import org.springframework.stereotype.Service;

@Service
public class CastRegisterServiceImpl implements CastRegisterService {
    private final CastRepository castRepository;

    public CastRegisterServiceImpl(CastRepository castRepository) {
        this.castRepository = castRepository;
    }

    @Override
    public Cast register(CastRequest request) {
        Cast cast = new Cast(request.firstName(), request.lastName(), request.birthDate(), request.photoUrl(), request.occupationIdentifier());

        return castRepository.save(cast);
    }
}