package com.cinelist.ms.actorsdirectors.services.register;

import com.cinelist.ms.actorsdirectors.database.models.Actor;
import com.cinelist.ms.actorsdirectors.dtos.actors.ActorRequest;

public interface ActorRegisterService {
    Actor register(ActorRequest request);
}