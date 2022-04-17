package com.topvel.user.service;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import com.topvel.comment.model.Searchs;
import com.topvel.user.model.User;
import com.topvel.user.repository.UserMapper;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserServiceimpl implements UserService{
	
	private final UserMapper userMapper;

//	@Override
//	public List<User> getUserList(Searchs searchs) {
//		return userMapper.getUserList(searchs);
//	}
//
//	@Override
//	public int getUserListCnt(Searchs searchs) {
//		return userMapper.getUserListCnt(searchs);
//	}
	
	@Override
	public ResponseEntity<?> getId(String id) {
		if(!ObjectUtils.isEmpty(id)) {
			if(!userMapper.getId(id)) {
				return new ResponseEntity<>("사용 가능한 아이디입니다.", HttpStatus.OK);
			}else {
				return new ResponseEntity<>("이미 존재하는 아이디입니다.", HttpStatus.BAD_REQUEST);
			}
		}else {
			return new ResponseEntity<>("아이디를 입력해주세요.", HttpStatus.BAD_REQUEST);
		}
	}

	@Override
	public ResponseEntity<?> insertUser(User user) {
		System.out.println("asdasd" + user);
		if(!ObjectUtils.isEmpty(user)) {
			if(userMapper.insertUser(user)) {
				return new ResponseEntity<>("회원가입 되었습니다.", HttpStatus.OK);
			}
		}
		return new ResponseEntity<>("회원가입 실패하셨습니다.", HttpStatus.BAD_REQUEST);
	}

	@Override
	public String getUser(User user) {
		if(!ObjectUtils.isEmpty(user)) {
			return userMapper.getUser(user);
		}
		return null;
	}



}
