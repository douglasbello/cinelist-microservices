package com.cinelist.ms.ratings.database.repositories;

import com.cinelist.ms.ratings.database.models.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CommentRepository extends JpaRepository<Comment, UUID> {
}