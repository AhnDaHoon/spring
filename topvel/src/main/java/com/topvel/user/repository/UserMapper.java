package com.topvel.user.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.topvel.user.model.User;

@Mapper
public interface UserMapper {

	List<User> getUser();
	
	boolean getId(String id);
	
	boolean insertUser(User user);
	
	String getUser(User user);
}
