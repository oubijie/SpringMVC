package com.veryoo.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

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
	
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String register() {
		return "register";
	}
	
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String register(User user, String password2) {
		System.out.println("============注册用户");
		return "register";
	}
	
	
	@RequestMapping(value = "/exists")
	@ResponseBody
	public Map<String, Boolean> exists(String username) {
		System.out.println("正在检查用户名是否存在：" + username);
		User user = userService.getUserByUsername(username);
		Map<String, Boolean> result = new HashMap<String, Boolean>();
		if(user == null) {
			result.put("exists", false);
		}else {
			result.put("exists", true);
		}
		
		return result;
	}
	
	@RequestMapping(value = "/exists2")
	@ResponseBody
	public Map<String, Boolean> exists2(@RequestBody String username) {
		System.out.println("正在检查用户名是否存在：" + username);
		User user = userService.getUserByUsername(username);
		Map<String, Boolean> result = new HashMap<String, Boolean>();
		if(user == null) {
			result.put("exists", false);
		}else {
			result.put("exists", true);
		}
		
		return result;
	}
	
	
	
}
