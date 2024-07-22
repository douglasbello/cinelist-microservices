package com.cinelist.ms.catalog.database.repositories;

import com.cinelist.ms.catalog.database.models.Genre;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface GenreRepository extends JpaRepository<Genre, UUID> {
}
