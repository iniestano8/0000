package com.dbdou.admin.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.dbdou.admin.util.LoginUtil;

public class LoginInterceptor extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		
		if(LoginUtil.isLogin(request)){
			return true;
		}
		response.sendRedirect("/login/toLogin");
		return false;
	}

}
