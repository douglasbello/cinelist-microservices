package com.cinelist.ms.catalog.database.repositories;

import com.cinelist.ms.catalog.database.models.Language;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LanguageRepository extends JpaRepository<Language, String> {
}
