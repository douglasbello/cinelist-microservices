package com.cinelist.ms.actorsdirectors.database.repositories;

import com.cinelist.ms.actorsdirectors.database.models.Occupation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface OccupationRepository extends JpaRepository<Occupation, UUID> {
}