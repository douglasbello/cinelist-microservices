package com.cinelist.ms.ratings.services.comments.search;

import com.cinelist.ms.ratings.database.models.Comment;

import java.util.UUID;

public interface CommentSearchService {
    Comment findByIdentifier(UUID identifier);
}