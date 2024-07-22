package com.cinelist.ms.catalog.database.repositories;

import com.cinelist.ms.catalog.database.models.Season;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface SeasonRepository extends JpaRepository<Season, UUID> {
}