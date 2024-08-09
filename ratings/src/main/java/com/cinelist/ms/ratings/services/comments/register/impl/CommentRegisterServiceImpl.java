package com.cinelist.ms.ratings.services.comments.register.impl;

import com.cinelist.ms.ratings.client.MoviesClient;
import com.cinelist.ms.ratings.database.models.Comment;
import com.cinelist.ms.ratings.database.repositories.CommentRepository;
import com.cinelist.ms.ratings.dtos.client.MovieResponse;
import com.cinelist.ms.ratings.dtos.comments.CommentRequest;
import com.cinelist.ms.ratings.services.comments.register.CommentRegisterService;
import org.springframework.stereotype.Service;

@Service
public class CommentRegisterServiceImpl implements CommentRegisterService {
    private final CommentRepository commentRepository;
    private final MoviesClient moviesClient;

    public CommentRegisterServiceImpl(CommentRepository commentRepository, MoviesClient moviesClient) {
        this.commentRepository = commentRepository;
        this.moviesClient = moviesClient;
    }

    @Override
    public Comment comment(CommentRequest request) {
        MovieResponse movieExists = moviesClient.findByIdentifier(request.mediaIdentifier()).getBody();

        return null;
    }
}