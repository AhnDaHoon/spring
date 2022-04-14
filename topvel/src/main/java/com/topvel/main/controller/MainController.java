package com.topvel.main.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/main")
public class MainController {

	@GetMapping("/home")
	public String home(Model model, String loginId, HttpServletRequest request) {
		HttpSession session = request.getSession();
		System.out.println("asdasd"+loginId);
		session.setAttribute("loginId", loginId);
		return "/main/main";
	}
}
