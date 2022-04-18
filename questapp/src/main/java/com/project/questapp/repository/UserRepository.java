package com.project.questapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.questapp.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {

	User findByUserName(String userName);

}
