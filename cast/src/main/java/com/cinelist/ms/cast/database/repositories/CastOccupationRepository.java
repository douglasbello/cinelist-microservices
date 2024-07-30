package com.cinelist.ms.cast.database.repositories;

import com.cinelist.ms.cast.database.models.CastOccupation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CastOccupationRepository extends JpaRepository<CastOccupation, UUID> {
}