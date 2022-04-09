package com.topvel.comment.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.topvel.user.model.User;
import com.topvel.user.repository.UserMapper;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserServiceimpl implements UserService{
	
	private final UserMapper userMapper;

	@Override
	public List<User> getUser() {
		return userMapper.getUser();
	}

}
