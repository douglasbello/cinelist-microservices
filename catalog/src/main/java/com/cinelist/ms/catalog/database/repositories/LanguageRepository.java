package com.cinelist.ms.catalog.database.repositories;

import com.cinelist.ms.catalog.database.models.Language;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.UUID;

public interface LanguageRepository extends JpaRepository<Language, UUID> {
    @Query(nativeQuery = true, value = "SELECT * FROM tb_languages WHERE name LIKE '%?1%'")
    Language findByName(String name);
}