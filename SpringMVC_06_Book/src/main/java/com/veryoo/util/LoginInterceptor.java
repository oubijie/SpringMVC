package com.veryoo.util;

import java.util.Arrays;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.veryoo.entity.User;

/**
 * 登录拦截器
 * 
 * @author Administrator
 *
 */
public class LoginInterceptor implements HandlerInterceptor {

	@Override
	public void afterCompletion(HttpServletRequest req, HttpServletResponse resp, Object handler, Exception ex)
			throws Exception {

	}

	@Override
	public void postHandle(HttpServletRequest req, HttpServletResponse resp, Object handler, ModelAndView mv)
			throws Exception {

	}

	@Override
	public boolean preHandle(HttpServletRequest req, HttpServletResponse resp, Object handler) throws Exception {
		HttpSession session = req.getSession();
		String contextPath = session.getServletContext().getContextPath();
		String[] noNeedAuthPage = { "/login", "/logout", "/register" };

		String uri = req.getRequestURI();
		uri = uri.replace(contextPath, "");
		System.out.println("=================uri:" + uri);

		if (!Arrays.asList(noNeedAuthPage).contains(uri)) {
			if (session.getAttribute("loginUser") == null) {
				resp.sendRedirect(contextPath+"/login");
				return false;
			}
		}

		return true;
	}

}
