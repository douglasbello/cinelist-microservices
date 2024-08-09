package com.cinelist.ms.ratings.controllers.comments.register.impl;

import com.cinelist.ms.ratings.controllers.comments.register.CommentRegisterController;
import com.cinelist.ms.ratings.database.models.Comment;
import com.cinelist.ms.ratings.dtos.comments.CommentRequest;
import com.cinelist.ms.ratings.services.comments.register.CommentRegisterService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/comments")
public class CommentRegisterControllerImpl implements CommentRegisterController {
    private final CommentRegisterService commentRegisterService;

    public CommentRegisterControllerImpl(CommentRegisterService commentRegisterService) {
        this.commentRegisterService = commentRegisterService;
    }

    @PostMapping
    public ResponseEntity<Comment> comment(@RequestBody CommentRequest request) {
        commentRegisterService.comment(request);

        return ResponseEntity.noContent().build();
    }
}