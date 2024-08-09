package com.cinelist.ms.ratings.controllers.comments.search.impl;

import com.cinelist.ms.ratings.controllers.comments.search.CommentSearchController;
import com.cinelist.ms.ratings.database.models.Comment;
import com.cinelist.ms.ratings.services.comments.search.CommentSearchService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/comments")
public class CommentSearchControllerImpl implements CommentSearchController {
    private final CommentSearchService commentSearchService;

    public CommentSearchControllerImpl(CommentSearchService commentSearchService) {
        this.commentSearchService = commentSearchService;
    }

    @GetMapping("/{identifier}")
    public ResponseEntity<Comment> findByIdentifier(@PathVariable UUID identifier) {
        return ResponseEntity.ok().body(commentSearchService.findByIdentifier(identifier));
    }
}