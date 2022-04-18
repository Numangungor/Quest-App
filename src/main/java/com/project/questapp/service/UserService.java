package com.project.questapp.service;

import java.util.List;

import com.project.questapp.entity.User;

public interface UserService {
	
	List<User> getAllUsers();

	User saveOneUser(User newUser);

	User getOneUserById(Long userId);

	User updateOneUser(Long userId, User newUser);

	void deleteById(Long userId);

	User getOneUserByUserName(String userName);


}
