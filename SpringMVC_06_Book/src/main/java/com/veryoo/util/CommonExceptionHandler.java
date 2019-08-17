package com.veryoo.util;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

/**
 * 使用@ControllerAdvice声明通用处理类
 * @author Administrator
 *
 */
@ControllerAdvice
public class CommonExceptionHandler {

	@ExceptionHandler()
	public ModelAndView handleException(Exception ex) {
		System.out.println(ex);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("error/err");
		mv.addObject("exception", ex);
		return mv;
	}
	
	@ExceptionHandler({NullPointerException.class})
	public ModelAndView handleNullPointerException(Exception ex) {
		System.out.println(ex);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("error/err");
		mv.addObject("exception", ex);
		System.out.println("=======================null point");
		return mv;
	}
}
