package com.cinelist.ms.catalog.database.repositories;

import com.cinelist.ms.catalog.database.models.Platform;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.UUID;

public interface PlatformRepository extends JpaRepository<Platform, UUID> {
    @Query(value = "SELECT p FROM Platform p WHERE LOWER(p.name) LIKE LOWER(CONCAT('%', :name, '%'))")
    Page<Platform> findByName(@Param("name") String name, Pageable pageable);
}