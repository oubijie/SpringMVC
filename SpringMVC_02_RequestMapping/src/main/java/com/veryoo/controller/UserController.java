package com.veryoo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/user")   //窄化url
public class UserController {

	@RequestMapping("/list")   //映射一个url
	public String list() {
		System.out.println("Method list!");
		return "success";
	}
	
	@RequestMapping(value={"/save","/add"} )   //映射多个url
	public String save() {
		System.out.println("Method save!");
		return "success";
	}
	
	@RequestMapping(value="/update", method=RequestMethod.POST ) //限定请求的方法
	public String update() {
		System.out.println("Method update!");
		return "success";
	}
}
