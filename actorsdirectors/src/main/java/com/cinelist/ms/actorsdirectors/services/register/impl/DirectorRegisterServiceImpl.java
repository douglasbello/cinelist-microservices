package com.cinelist.ms.actorsdirectors.services.register.impl;

import com.cinelist.ms.actorsdirectors.database.models.Director;
import com.cinelist.ms.actorsdirectors.database.repositories.DirectorRepository;
import com.cinelist.ms.actorsdirectors.dtos.directors.DirectorRequest;
import com.cinelist.ms.actorsdirectors.services.register.DirectorRegisterService;
import org.springframework.stereotype.Service;

@Service
public class DirectorRegisterServiceImpl implements DirectorRegisterService {
    private final DirectorRepository directorRepository;

    public DirectorRegisterServiceImpl(DirectorRepository directorRepository) {
        this.directorRepository = directorRepository;
    }

    @Override
    public Director register(DirectorRequest request) {
        Director director = new Director(request.firstName(), request.lastName(), request.birthDate(), request.photoUrl());

        return directorRepository.save(director);
    }
}