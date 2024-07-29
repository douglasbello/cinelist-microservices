package com.cinelist.ms.cast.database.repositories;

import com.cinelist.ms.cast.database.models.Cast;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CastRepository extends JpaRepository<Cast, UUID> {
}