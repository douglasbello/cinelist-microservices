package com.cinelist.ms.catalog.database.repositories;

import com.cinelist.ms.catalog.database.models.Language;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.UUID;

public interface LanguageRepository extends JpaRepository<Language, UUID> {
    @Query(value = "SELECT l FROM Language l WHERE LOWER(l.name) LIKE LOWER(CONCAT('%', :name, '%'))")
    Page<Language> findAllByName(@Param("name") String name, Pageable pageable);
}