package com.cinelist.ms.catalog.database.repositories;

import com.cinelist.ms.catalog.database.models.Genre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.UUID;

public interface GenreRepository extends JpaRepository<Genre, UUID> {
    @Query("SELECT g FROM Genre g WHERE LOWER(g.name) LIKE LOWER(CONCAT('%', :name, '%'))")
    Genre findByName(@Param("name") String name);}