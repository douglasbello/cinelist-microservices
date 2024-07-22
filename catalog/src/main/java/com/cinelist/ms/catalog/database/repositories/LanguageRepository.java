package com.cinelist.ms.catalog.database.repositories;

import com.cinelist.ms.catalog.database.models.Language;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface LanguageRepository extends JpaRepository<Language, UUID> {
}
