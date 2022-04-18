package com.project.questapp.responses;

import com.project.questapp.entity.User;

public class UserResponse {
	
	Long id;
	int avatarId;
	String userName;
	
	public UserResponse(User entity) {
		this.id=entity.getId();
		this.avatarId=entity.getAvatar();
		this.userName=entity.getUserName();
	}

}
