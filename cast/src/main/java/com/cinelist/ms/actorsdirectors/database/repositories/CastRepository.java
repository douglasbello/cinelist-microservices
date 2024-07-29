package com.cinelist.ms.actorsdirectors.database.repositories;

import com.cinelist.ms.actorsdirectors.database.models.Cast;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CastRepository extends JpaRepository<Cast, UUID> {
}