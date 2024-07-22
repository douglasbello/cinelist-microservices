package com.cinelist.ms.catalog.database.repositories;

import com.cinelist.ms.catalog.database.models.Show;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ShowRepository extends JpaRepository<Show, UUID> {
}