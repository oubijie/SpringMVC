package com.veryoo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class HelloController {

	@RequestMapping("/hello")
	public String hello(){
		System.out.println("Hello World from controller");
		return "success";
	}
}
