package com.cinelist.ms.ratings.dtos.comments;

import java.util.UUID;

public record CommentRequest(String text, UUID mediaIdentifier) {
}