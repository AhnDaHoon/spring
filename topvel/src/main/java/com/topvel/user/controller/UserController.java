package com.topvel.user.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.topvel.user.model.User;
import com.topvel.user.service.UserService;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

	

	private final UserService userService;
	
	@GetMapping("/list")
	public String list(Model model, String loginId, HttpServletRequest request) {

		
		return "/user/list";
	}
	
	@GetMapping("/signup")
	public String singUpForm() {
		
		return "/user/signup/signup";
	}
	
	@PutMapping("/signup")
	public ResponseEntity<?> singUp(User user){
		System.out.println("asdasd" + user);

		return userService.insertUser(user);
	}
	
	@GetMapping("/singupCheck/{id}")
	public ResponseEntity<?> idCheck(@PathVariable String id){
		
		return userService.getId(id);
	}
	
	@GetMapping("/login")
	public String loginForm(){
		
		return "/user/login/login";
	}
	
	@PostMapping("/login")
	public ResponseEntity<?> login(Model model, User user, HttpServletRequest request){
		
		System.out.println("user" + user);
		String id = userService.getUser(user);
		if(!ObjectUtils.isEmpty(id) ) {
			HttpSession session = request.getSession();
			session.setAttribute("loginId", id);
			return new ResponseEntity<>("", HttpStatus.OK);
		}
		
		return new ResponseEntity<>("아이디와 비밀번호를 확인하세요.", HttpStatus.BAD_REQUEST);

	}
	
	@GetMapping("/move-main")
	public String main(Model model, User user, HttpServletRequest request) {
		HttpSession session = request.getSession();
		session.setAttribute("loginId", user.getId());
		return "/main/main";
	}
	
	@GetMapping("/find")
	public String find(){
		
		return "/user/login/findIdPw";
	}
}
