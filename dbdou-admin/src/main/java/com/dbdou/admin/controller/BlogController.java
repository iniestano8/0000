package com.dbdou.admin.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.dbdou.admin.user.model.User;

@Controller
@RequestMapping("/blogManage")
public class BlogController extends BaseController {

	@RequestMapping("/addBlog")
	public ModelAndView toAdd(ModelAndView mav, HttpServletRequest request) {
		User user = getLoginUser(request);
		mav.getModel().put("user", user);
		mav.getModel().put("authes", getAuthesByLoginUser(user));
		mav.setViewName("blog/blog-add");
		return mav;
	}
	
}
