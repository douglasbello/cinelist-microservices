package com.cinelist.ms.catalog.database.repositories;

import com.cinelist.ms.catalog.database.models.MoviesLanguages;
import com.cinelist.ms.catalog.database.models.MoviesLanguagesId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MoviesLanguagesRepository extends JpaRepository<MoviesLanguages, MoviesLanguagesId> {
}