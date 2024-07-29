package com.cinelist.ms.cast.database.repositories;

import com.cinelist.ms.cast.database.models.Occupation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface OccupationRepository extends JpaRepository<Occupation, UUID> {
}