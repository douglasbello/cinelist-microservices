package com.cinelist.ms.ratings.services.comments.register;

import com.cinelist.ms.ratings.database.models.Comment;
import com.cinelist.ms.ratings.dtos.comments.CommentRequest;

public interface CommentRegisterService {
    Comment register(CommentRequest request);
}