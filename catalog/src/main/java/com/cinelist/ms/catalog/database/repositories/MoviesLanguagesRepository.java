package com.cinelist.ms.catalog.database.repositories;

import com.cinelist.ms.catalog.database.models.MoviesLanguages;
import com.cinelist.ms.catalog.database.models.MoviesLanguagesId;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.UUID;

public interface MoviesLanguagesRepository extends JpaRepository<MoviesLanguages, MoviesLanguagesId> {
    @Query(value = "SELECT ml FROM MoviesLanguages ml WHERE ml.id.languageIdentifier = :identifier")
    Page<MoviesLanguages> findAllByLanguageIdentifier(@Param("identifier") UUID languageIdentifier, Pageable pageable);
}