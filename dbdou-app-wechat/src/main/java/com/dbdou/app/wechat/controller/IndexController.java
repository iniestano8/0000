package com.dbdou.app.wechat.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("")
public class IndexController {

	@RequestMapping("")
	public ModelAndView toIndex(ModelAndView mav) {

		mav.setViewName("index");
		return mav;
	}
}
