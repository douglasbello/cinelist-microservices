package com.cinelist.ms.catalog.database.repositories;

import com.cinelist.ms.catalog.database.models.Platform;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlatformRepository extends JpaRepository<Platform, String> {
}