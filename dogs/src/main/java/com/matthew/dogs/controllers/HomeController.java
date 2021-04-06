package com.matthew.dogs.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.matthew.dogs.models.Dog;
import com.matthew.dogs.services.DogService;

@Controller
public class HomeController {
	@Autowired
	private DogService dService;
	
	@GetMapping("/")
	public String index(Model viewModel) {
		List<Dog> dogs = this.dService.getAllPets();
		viewModel.addAttribute("allDogs", dogs);
		return "index.jsp";
	}
	
	@GetMapping("/add")
	public String add(@ModelAttribute("dog") Dog dog) {
		return "add.jsp";
	}
	
	@PostMapping("/addDog")
	public String addDog(@Valid @ModelAttribute("dog") Dog dog, BindingResult result) {
		if(result.hasErrors()) {
			return "add.jsp";
		} else {
			this.dService.createDog(dog);
			return "redirect:/";
		}
	}
	
	@PostMapping("/addDogHtmlWay")
	public String addDogHTML(@RequestParam("name") String name, @RequestParam("breed") String breed, @RequestParam("age") int age, RedirectAttributes redirectAttr) {
		ArrayList<String> errors = new ArrayList<String>();
		if(name.equals("")) {
			errors.add("Hey you, yeah you, you forgot to add a name");
		}
		if(errors.size() > 0) {
			for(String e: errors) {
				redirectAttr.addFlashAttribute("errors", e);
			}
			return "redirect:/add";
		}
		this.dService.createNewDog(name, breed, age);
		return "redirect:/";
	}
}
