package com.project.questapp.service.manager;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.project.questapp.entity.Like;
import com.project.questapp.repository.LikeRepository;
import com.project.questapp.request.LikeCreateRequest;
import com.project.questapp.responses.LikeResponse;
import com.project.questapp.service.LikeService;
import com.project.questapp.service.PostService;
import com.project.questapp.service.UserService;

@Service
public class LikeManager implements LikeService {

	private LikeRepository likeRepository;
	private UserService userService;
	private PostService postService;

	

	public LikeManager(LikeRepository likeRepository, UserService userService, PostService postService) {
		this.likeRepository = likeRepository;
		this.userService = userService;
		this.postService = postService;
	}

	@Override
	public List<LikeResponse> getAllLikesWithParam(Optional<Long> userId, Optional<Long> postId) {
		List<Like> list;
		if(userId.isPresent() && postId.isPresent()) {
			list = likeRepository.findByUserIdAndPostId(userId.get(), postId.get());
		}else if(userId.isPresent()) {
			list = likeRepository.findByUserId(userId.get());
		}else if(postId.isPresent()) {
			list = likeRepository.findByPostId(postId.get());
		}else
			list = likeRepository.findAll();
		return list.stream().map(like -> new LikeResponse(like)).collect(Collectors.toList());
	}

	@Override
	public Like getOneLikeById(Long likeId) {
		return likeRepository.findById(likeId).orElse(null);
	}

	@Override
	public Like createOneLike(LikeCreateRequest request) {
		var user = userService.getOneUserById(request.getId());
		var post=postService.getOnePostById(request.getPostId());
		if(user !=null && post !=null) {
			var likeToSave=new Like();
			likeToSave.setId(request.getId());
			likeToSave.setUser(user);
			likeToSave.setPost(post);
			return likeRepository.save(likeToSave);
		}else
		return null;
	}

	@Override
	public void deleteOneLikeById(Long likeId) {
		likeRepository.deleteById(likeId);
		
	}

	
	
}