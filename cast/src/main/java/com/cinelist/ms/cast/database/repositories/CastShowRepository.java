package com.cinelist.ms.cast.database.repositories;

import com.cinelist.ms.cast.database.models.CastShow;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CastShowRepository extends JpaRepository<CastShow, UUID> {
}