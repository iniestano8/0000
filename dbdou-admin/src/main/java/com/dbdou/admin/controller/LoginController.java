package com.dbdou.admin.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.dbdou.admin.user.model.User;
import com.dbdou.admin.user.service.IUserService;
import com.dbdou.util.common.ValidateUtil;
import com.dbdou.util.data.Data;

@Controller
@RequestMapping("/login")
public class LoginController {

	@Autowired
	private IUserService userService;

	@RequestMapping("")
	public String login(User user, HttpServletResponse response) {
		user = userService.getByNameAndPwd(user);
		if (ValidateUtil.isValid(user)) {
			Cookie cookie = new Cookie("user", user.toJsonStr());
			cookie.setMaxAge(6000);
			cookie.setPath("/");
			response.addCookie(cookie);
		}
		return "redirect:/";
	}

	@RequestMapping("/toLogin")
	public ModelAndView toLogin(ModelAndView mav) {

		mav.setViewName("login");
		return mav;
	}

	@ResponseBody
	@RequestMapping("/doLogin")
	public Data doLogin(@RequestParam("name") String name,
			@RequestParam("password") String password) {
		Data data = new Data(500);
		// TODO deal login

		return data;
	}

	@RequestMapping("/logout")
	public String logout(HttpServletResponse response) {
		Cookie cookie = new Cookie("user", null);
		cookie.setMaxAge(0);
		cookie.setPath("/");
		response.addCookie(cookie);
		return "redirect:/login/toLogin";
	}
}
