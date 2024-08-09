package com.cinelist.ms.ratings.controllers.comments.register;

import com.cinelist.ms.ratings.database.models.Comment;
import com.cinelist.ms.ratings.dtos.comments.CommentRequest;
import org.springframework.http.ResponseEntity;

public interface CommentRegisterController {
    ResponseEntity<Comment> comment(CommentRequest request);
}