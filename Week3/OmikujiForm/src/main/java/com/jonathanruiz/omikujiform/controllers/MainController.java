package com.jonathanruiz.omikujiform.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {
	@RequestMapping("/")
	public String index() {
		return "index.jsp";
	}
	
	@RequestMapping("/retrieve")
	public String retrieve(
			@RequestParam(value="num")Integer num,
			@RequestParam(value="city") String city, 
			@RequestParam(value="person")String person,
			@RequestParam(value="hobby")String hobby,
			@RequestParam(value="noun")String noun,
			@RequestParam(value="comment")String comment,
			HttpSession session
			) {
		session.setAttribute("num", num);
		session.setAttribute("city", city);
		session.setAttribute("person", person);
		session.setAttribute("hobby", hobby);
		session.setAttribute("noun", noun);
		session.setAttribute("comment", comment);
		return "redirect:/show";
	}
	
	@RequestMapping("/show")
	public String show() {
		return "show.jsp";
	}
}
