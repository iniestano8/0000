package com.dbdou.admin.controller;

import java.util.Arrays;
import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.dbdou.admin.auth.model.Auth;
import com.dbdou.admin.auth.service.IAuthService;
import com.dbdou.admin.role.model.Role;
import com.dbdou.admin.role.service.IRoleService;
import com.dbdou.admin.user.model.User;
import com.dbdou.admin.user.service.IUserService;
import com.dbdou.util.common.ValidateUtil;

@Controller
public class BaseController {

	@Autowired
	private IUserService userService;
	@Autowired
	private IAuthService authService;
	@Autowired
	private IRoleService roleService;

	@RequestMapping("/")
	public ModelAndView toIndex(ModelAndView mav, HttpServletRequest request) {
		User user = getLoginUser(request);
		mav.getModel().put("user", user);
		mav.getModel().put("authes", getAuthesByLoginUser(user));
		mav.setViewName("index");
		return mav;
	}

	protected User getLoginUser(HttpServletRequest request) {
		User user = null;
		Cookie[] cookies = request.getCookies();
		if (ValidateUtil.isValid(cookies)) {
			for (Cookie cookie : cookies) {
				if ("user".equals(cookie.getName())) {
					user = User.getUserFromJson(cookie.getValue());
					break;
				}
			}
		}
		if (ValidateUtil.isValid(user)) {
			user = userService.getList(user).get(0);
		}
		return user;
	}

	protected Role getRoleByLoginUser(HttpServletRequest request) {

		return getRoleByLoginUser(getLoginUser(request));
	}

	protected Role getRoleByLoginUser(User user) {
		Role role = new Role();
		String roleStr = user.getRoles();
		if (ValidateUtil.isValid(roleStr)) {
			String[] roleArr = roleStr.split("-");
			if (ValidateUtil.isValid(roleArr)) {
				role = roleService.getById(Integer.parseInt(roleArr[0]));
			}
		}
		return role;
	}

	protected List<Auth> getAuthesByLoginUser(HttpServletRequest request) {
		List<Auth> authes = null;
		String authStr = getRoleByLoginUser(request).getAuthes();
		if (ValidateUtil.isValid(authStr)) {
			String[] authArr = authStr.split("\\+");
			authes = authService.getByIds(Arrays.asList(authArr));
		}
		return authes;
	}

	protected List<Auth> getAuthesByLoginUser(User user) {
		List<Auth> authes = null;
		String authStr = getRoleByLoginUser(user).getAuthes();
		if (ValidateUtil.isValid(authStr)) {
			String[] authArr = authStr.split("\\+");
			authes = authService.getByIds(Arrays.asList(authArr));
		}
		return authes;
	}

}
