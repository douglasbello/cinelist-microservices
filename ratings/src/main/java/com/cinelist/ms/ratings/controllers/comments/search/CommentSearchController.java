package com.cinelist.ms.ratings.controllers.comments.search;

import com.cinelist.ms.ratings.database.models.Comment;
import org.springframework.http.ResponseEntity;

import java.util.UUID;

public interface CommentSearchController {
    ResponseEntity<Comment> findByIdentifier(UUID identifier);
}