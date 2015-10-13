package com.dbdou.admin.util;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import com.dbdou.util.common.ValidateUtil;

public class LoginUtil {

	public static boolean isLogin(HttpServletRequest request){
		boolean flag = false;
		Cookie[] cookies = request.getCookies();
		if(ValidateUtil.isValid(cookies)){
			for(Cookie cookie : cookies){
				if("user".equals(cookie.getName())){
					flag = true;
					break;
				}
			}
		}
		return flag;
	}
	
}
