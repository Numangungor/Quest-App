package com.project.questapp.service;

import java.util.List;
import java.util.Optional;

import com.project.questapp.entity.Post;
import com.project.questapp.request.PostCreateRequest;
import com.project.questapp.request.PostUpdateRequest;
import com.project.questapp.responses.PostResponse;

public interface PostService {
	
	List<PostResponse> getAllPost(Optional<Long> userId);

	Post getOnePostById(Long postId);

	Post createOnePost(PostCreateRequest newPostRequest);

	Post updateOnePostById(Long postId, PostUpdateRequest postUpdateRequest);

	void deleteOnePostById(Long postId);



}
