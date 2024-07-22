package com.cinelist.ms.catalog.database.repositories;

import com.cinelist.ms.catalog.database.models.MoviesLanguages;
import com.cinelist.ms.catalog.database.models.MoviesLanguagesId;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface MoviesLanguagesRepository extends JpaRepository<MoviesLanguages, MoviesLanguagesId> {
    Page<MoviesLanguages> findAllByLanguageIdentifier(UUID languageIdentifier, Pageable pageable);
}