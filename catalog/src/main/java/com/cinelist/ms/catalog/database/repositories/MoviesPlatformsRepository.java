package com.cinelist.ms.catalog.database.repositories;

import com.cinelist.ms.catalog.database.models.MoviesPlatforms;
import com.cinelist.ms.catalog.database.models.MoviesPlatformsId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MoviesPlatformsRepository extends JpaRepository<MoviesPlatforms, MoviesPlatformsId> {
}