package com.dbdou.app.blog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/blog")
public class BlogController {

	@RequestMapping("")
	public ModelAndView toBlog(ModelAndView mav) {

		mav.setViewName("blog");
		return mav;
	}

}
