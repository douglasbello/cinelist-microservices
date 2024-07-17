package com.cinelist.ms.catalog.database.repositories;

import com.cinelist.ms.catalog.database.models.ShowsLanguages;
import com.cinelist.ms.catalog.database.models.ShowsLanguagesId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShowsLanguagesRepository extends JpaRepository<ShowsLanguages, ShowsLanguagesId> {
}