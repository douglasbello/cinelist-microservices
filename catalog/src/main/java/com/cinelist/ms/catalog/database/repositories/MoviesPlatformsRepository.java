package com.cinelist.ms.catalog.database.repositories;

import com.cinelist.ms.catalog.database.models.MoviesPlatforms;
import com.cinelist.ms.catalog.database.models.MoviesPlatformsId;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MoviesPlatformsRepository extends JpaRepository<MoviesPlatforms, MoviesPlatformsId> {
    Page<MoviesPlatforms> findAllByPlatformIdentifier(String platformIdentifier, Pageable pageable);
}