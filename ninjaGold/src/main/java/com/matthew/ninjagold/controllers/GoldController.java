package com.matthew.ninjagold.controllers;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Random;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class GoldController {
	
//	@RequestMapping(value="/", method=RequestMethod.POST)
//	public String gold() {
//		return "gold.jsp";
//	}
	
	@GetMapping("/")
	public String gold(HttpSession session, Model viewModel) {
		ArrayList<String> activity = new ArrayList<String>();
		if(session.getAttribute("gold") == null) {
			session.setAttribute("gold", 0);
		}
		if(session.getAttribute("activity") == null) {
			session.setAttribute("activity", activity);
		}
		viewModel.addAttribute("totalGold", session.getAttribute("gold"));
		viewModel.addAttribute("activity", session.getAttribute("activity"));
		return "index.jsp";
	}
	
	@PostMapping("/findgold")
	public String findGold(HttpSession session, @RequestParam("building") String building) {
		Random r = new Random();
		LocalDateTime now = LocalDateTime.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMMM dd YYYY h:mma");
		ArrayList<String> activity = (ArrayList<String>)session.getAttribute("activity");
		int gold = (int)session.getAttribute("gold");
		int goldThisTurn;
		if(building.equals("farm")) {
			// Do Farm Stuff
			goldThisTurn = r.nextInt((20 - 10) +1) + 10;
			activity.add(String.format("You entered a %s and earned %d gold %s \n", building, goldThisTurn, now));
		} else if(building.equals("cave")) {
			// do cave stuff
			goldThisTurn = r.nextInt((10 - 5) +1) + 5;
			activity.add(String.format("You entered a %s and earned %d gold %s \n", building, goldThisTurn, now));
		} else if(building.equals("house")) {
			// do house stuff
			goldThisTurn = r.nextInt((5 - 2) +1) + 2;
			activity.add(String.format("You entered a %s and earned %d gold %s \n", building, goldThisTurn, now));
		} else {
			// Do Casino Stuff
			goldThisTurn = r.nextInt((50 + 50) +1) -50;
			if(goldThisTurn < 0) {
				activity.add(String.format("You entered a %s and lost %d gold. ouch! %s \n", building, goldThisTurn, now));
			} else {
				activity.add(String.format("You entered a %s and won! %d gold %s \n", building, goldThisTurn, now));
			}
		}
		
		int totalGold = gold += goldThisTurn;
		session.setAttribute("gold", totalGold);
		session.setAttribute("activity", activity);
		return "redirect:/";
	}
}
