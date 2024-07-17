package com.cinelist.ms.catalog.database.repositories;

import com.cinelist.ms.catalog.database.models.ShowsPlatforms;
import com.cinelist.ms.catalog.database.models.ShowsPlatformsId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShowsPlatformsRepository extends JpaRepository<ShowsPlatforms, ShowsPlatformsId> {
}