package com.cinelist.ms.cast.database.repositories;

import com.cinelist.ms.cast.database.models.Cast;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.UUID;

public interface CastRepository extends JpaRepository<Cast, UUID> {
    @Query(value = "SELECT c FROM Cast c WHERE LOWER(c.firstName) LIKE LOWER(CONCAT('%', :name, '%')) OR LOWER(c.lastName) LIKE LOWER(CONCAT('%', :name, '%')) " +
            "OR LOWER(CONCAT(c.firstName, c.lastName)) LIKE LOWER(CONCAT('%', :name, '%'))")
    Page<Cast> findByName(@Param("name") String name, Pageable pageable);
    Page<Cast> findAllByOccupationIdentifier(UUID occupationIdentifier, Pageable pageable);
}