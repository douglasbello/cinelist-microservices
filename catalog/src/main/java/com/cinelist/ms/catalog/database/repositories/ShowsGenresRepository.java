package com.cinelist.ms.catalog.database.repositories;

import com.cinelist.ms.catalog.database.models.ShowsGenres;
import com.cinelist.ms.catalog.database.models.ShowsGenresId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShowsGenresRepository extends JpaRepository<ShowsGenres, ShowsGenresId> {
}