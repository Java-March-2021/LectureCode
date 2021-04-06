package com.matthew.firstproject.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class HomeController {
	
	@RequestMapping(value="/", method=RequestMethod.GET)
	public String hello() {
		return "index.jsp";
	}
	
	@RequestMapping(value="/submitJoke", method=RequestMethod.POST)
	public String displayJoke(@RequestParam("name") String name, @RequestParam("joke") String joke, Model viewModel) {
		viewModel.addAttribute("name", name);
		viewModel.addAttribute("joke", joke);		
		return "result.jsp";
	}
	
	
	// @PathVariable
	@RequestMapping(value="/favcolor/{color}")
	public String displayColor(@PathVariable("color") String color, Model viewModel) {
		viewModel.addAttribute("color", color);
		return "favcolor.jsp";
	}
}
