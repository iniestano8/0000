package com.dbdou.app.blog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/game")
public class GameController {

	@RequestMapping("")
	public ModelAndView toGameIndex(ModelAndView mav) {

		mav.setViewName("/game/count-down-digit");
		return mav;
	}

}
