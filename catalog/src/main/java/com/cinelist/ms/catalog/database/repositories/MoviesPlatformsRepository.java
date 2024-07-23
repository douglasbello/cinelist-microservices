package com.cinelist.ms.catalog.database.repositories;

import com.cinelist.ms.catalog.database.models.MoviesPlatforms;
import com.cinelist.ms.catalog.database.models.MoviesPlatformsId;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.UUID;

public interface MoviesPlatformsRepository extends JpaRepository<MoviesPlatforms, MoviesPlatformsId> {
    @Query(value = "SELECT mp FROM MoviesPlatforms mp WHERE mp.id.platformIdentifier = :identifier")
    Page<MoviesPlatforms> findAllByPlatformIdentifier(@Param("identifier") UUID platformIdentifier, Pageable pageable);
}