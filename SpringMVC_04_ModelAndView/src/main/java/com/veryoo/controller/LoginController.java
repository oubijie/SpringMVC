package com.veryoo.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes(names = {"login2","login3"})
public class LoginController {

	@RequestMapping("/login")
	public String login(String username, HttpSession session) {
		session.setAttribute("loginUser", username);
		return "success";
	}
	
	@RequestMapping("/login2")
	public String login2(String username, Model model) {
		model.addAttribute("login2", username);
		return "success";
	}
	
	@RequestMapping("/login3")
	public String login3(String username, ModelMap model) {
		model.addAttribute("login3", username);
		return "success";
	}
	
	
	@RequestMapping("/show3")
	public String show3(ModelMap model) {
		String name = (String)model.get("login3");
		System.out.println("name:" + name);
		
		String aaa = (String)model.get("aaa");
		System.out.println("aaa:" + aaa);
		
		return "success";
	}
}
