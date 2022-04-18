package com.project.questapp.service;

import java.util.List;
import java.util.Optional;

import com.project.questapp.entity.Comment;
import com.project.questapp.request.CommentCreateRequest;
import com.project.questapp.request.CommentUpdateRequest;

public interface CommentService {

	List<Comment> getAllCommentsWithParam(Optional<Long> userId, Optional<Long> postId);

	Comment getOneCommentById(Long commentId);

	Comment createOneComment(CommentCreateRequest request);

	Comment updateOneCommentById(Long commentId, CommentUpdateRequest request);

	void deleteOneCommentById(Long commentId);
}
