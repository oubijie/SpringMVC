package com.veryoo.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class FirstInterceptor implements HandlerInterceptor {

	//执行handler完成
	@Override
	public void afterCompletion(HttpServletRequest req, HttpServletResponse resp, Object handler, Exception ex)
			throws Exception {
		System.out.println("==============FirstInterceptor+afterCompletion");
		
	}

	//进入方法之后，返回modelAndView之前
	@Override
	public void postHandle(HttpServletRequest req, HttpServletResponse resp, Object handler, ModelAndView mv)
			throws Exception {
		System.out.println("==============FirstInterceptor+postHandle");
		
	}

	
	//进入handler方法之前
	@Override
	public boolean preHandle(HttpServletRequest req, HttpServletResponse resp, Object handler) throws Exception {
		System.out.println("==============FirstInterceptor+preHandle");
		return true;
	}

}
