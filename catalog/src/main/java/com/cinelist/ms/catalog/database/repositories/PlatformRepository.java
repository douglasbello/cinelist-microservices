package com.cinelist.ms.catalog.database.repositories;

import com.cinelist.ms.catalog.database.models.Platform;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.UUID;

public interface PlatformRepository extends JpaRepository<Platform, UUID> {
    @Query(nativeQuery = true, value = "SELECT * FROM tb_platforms WHERE name LIKE '%?1%'")
    Platform findByName(String name);
}