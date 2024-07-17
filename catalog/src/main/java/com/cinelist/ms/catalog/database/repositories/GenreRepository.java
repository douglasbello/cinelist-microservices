package com.cinelist.ms.catalog.database.repositories;

import com.cinelist.ms.catalog.database.models.Genre;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GenreRepository extends JpaRepository<Genre, String> {
}
