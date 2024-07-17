package com.cinelist.ms.catalog.database.repositories;

import com.cinelist.ms.catalog.database.models.Show;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShowRepository extends JpaRepository<Show, String> {
}