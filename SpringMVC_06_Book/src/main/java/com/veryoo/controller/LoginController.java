package com.veryoo.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.veryoo.entity.User;
import com.veryoo.service.UserService;

@Controller
public class LoginController {

	@Autowired
	private UserService userService;
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login() {
		return "login";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(String username, String password, Model model, HttpSession session) {
		User user = userService.getUserByUsername(username);
		
		if(user == null) {
			model.addAttribute("errMsg", "用户不存在！");
			return "login";
		}else if(!user.getPassword().equals(password)) {
			model.addAttribute("errMsg", "密码不正确！");
			return "login";
		}else {
			session.setAttribute("loginUser", user);
			return "redirect:/book/list";
		}
	}
}
