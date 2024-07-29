package com.cinelist.ms.actorsdirectors.database.repositories;

import com.cinelist.ms.actorsdirectors.database.models.Director;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface DirectorRepository extends JpaRepository<Director, UUID> {
}