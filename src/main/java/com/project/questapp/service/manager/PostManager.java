package com.project.questapp.service.manager;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import java.util.stream.Collectors;

import org.springframework.stereotype.Service;


import com.project.questapp.entity.Post;

import com.project.questapp.repository.PostRepository;
import com.project.questapp.request.PostCreateRequest;
import com.project.questapp.request.PostUpdateRequest;
import com.project.questapp.responses.LikeResponse;
import com.project.questapp.responses.PostResponse;
import com.project.questapp.service.LikeService;
import com.project.questapp.service.PostService;

import com.project.questapp.service.UserService;

@Service
public class PostManager implements PostService {

	private PostRepository postRepository;
	private UserService userService;
	private LikeService likeService;

	public PostManager(PostRepository postRepository, UserService userService,LikeService likeService) {
		this.postRepository = postRepository;
		this.userService = userService;
		this.likeService=likeService;}
	@Override
	public Post getOnePostById(Long postId) {
		return postRepository.findById(postId).orElse(null);
	}

	@Override
	public Post createOnePost(PostCreateRequest newPostRequest) {
		var user = userService.getOneUserById(newPostRequest.getUserId());
		if (user == null)
			return null;
		Post toSave = new Post();
		toSave.setId(newPostRequest.getId());
		toSave.setText(newPostRequest.getText());
		toSave.setTitle(newPostRequest.getTitle());
		toSave.setUser(user);
		toSave.setCreateDate(new Date());
		
		return postRepository.save(toSave);
	}

	@Override
	public Post updateOnePostById(Long postId, PostUpdateRequest postUpdateRequest) {
		Optional<Post> post= postRepository.findById(postId);
		if(post.isPresent()) {
			Post toUpdate = post.get();
			toUpdate.setText(postUpdateRequest.getText());
			toUpdate.setTitle(postUpdateRequest.getTitle());
			postRepository.save(toUpdate);
			return toUpdate;
		}
		return null;
	}

	@Override
	public void deleteOnePostById(Long postId) {
		postRepository.deleteById(postId);
	}


	@Override
	public List<PostResponse> getAllPost(Optional<Long> userId) {
		List<Post> list;
		if(userId.isPresent()) {
			list= postRepository.findByUserId(userId.get());
			
		}
		list = postRepository.findAll();
		return list.stream().map(p ->{
			List<LikeResponse> likes= likeService.getAllLikesWithParam(null, Optional.of(p.getId()));
			return new PostResponse(p,likes);}).collect(Collectors.toList());
		}


	
	

	

}
