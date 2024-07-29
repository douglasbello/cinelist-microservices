package com.cinelist.ms.actorsdirectors.database.repositories;

import com.cinelist.ms.actorsdirectors.database.models.Actor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ActorRepository extends JpaRepository<Actor, UUID> {
}