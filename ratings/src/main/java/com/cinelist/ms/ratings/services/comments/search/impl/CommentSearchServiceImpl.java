package com.cinelist.ms.ratings.services.comments.search.impl;

import com.cinelist.ms.ratings.database.models.Comment;
import com.cinelist.ms.ratings.database.repositories.CommentRepository;
import com.cinelist.ms.ratings.handlers.exceptions.ResourceNotFoundException;
import com.cinelist.ms.ratings.services.comments.search.CommentSearchService;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class CommentSearchServiceImpl implements CommentSearchService {
    private final CommentRepository commentRepository;

    public CommentSearchServiceImpl(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    @Override
    public Comment findByIdentifier(UUID identifier) {
        return commentRepository.findById(identifier).orElseThrow(() -> new ResourceNotFoundException("Comment", identifier));
    }
}