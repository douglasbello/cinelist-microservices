package com.cinelist.ms.cast.database.repositories;

import com.cinelist.ms.cast.database.models.CastMovie;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CastMovieRepository extends JpaRepository<CastMovie, UUID> {
}