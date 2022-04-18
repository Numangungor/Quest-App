package com.project.questapp.service;

import java.util.List;
import java.util.Optional;

import com.project.questapp.entity.Like;
import com.project.questapp.request.LikeCreateRequest;
import com.project.questapp.responses.LikeResponse;



public interface LikeService {

	List<LikeResponse> getAllLikesWithParam(Optional<Long> userId, Optional<Long> postId);

	Like getOneLikeById(Long likeId);

	Like createOneLike(LikeCreateRequest request);

	void deleteOneLikeById(Long likeId);

}