package com.topvel.user.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.topvel.user.model.User;

public interface UserService {

	List<User> getUser();
	
	ResponseEntity<?> getId(String id);

	ResponseEntity<?> insertUser(User user);
	
	String getUser(User user);
}
