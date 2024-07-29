package com.cinelist.ms.actorsdirectors.services.register.impl;

import com.cinelist.ms.actorsdirectors.database.models.Actor;
import com.cinelist.ms.actorsdirectors.database.repositories.ActorRepository;
import com.cinelist.ms.actorsdirectors.dtos.actors.ActorRequest;
import com.cinelist.ms.actorsdirectors.services.register.ActorRegisterService;
import org.springframework.stereotype.Service;

@Service
public class ActorRegisterServiceImpl implements ActorRegisterService {
    private final ActorRepository actorRepository;

    public ActorRegisterServiceImpl(ActorRepository actorRepository) {
        this.actorRepository = actorRepository;
    }

    @Override
    public Actor register(ActorRequest request) {
        Actor actor = new Actor(request.firstName(), request.lastName(), request.birthDate(), request.photoUrl());

        return actorRepository.save(actor);
    }
}