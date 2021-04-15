package com.matthew.dogs.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.matthew.dogs.models.Dog;
import com.matthew.dogs.models.Tag;
import com.matthew.dogs.models.Toy;
import com.matthew.dogs.models.User;
import com.matthew.dogs.services.DogService;
import com.matthew.dogs.services.TagService;
import com.matthew.dogs.services.ToyService;
import com.matthew.dogs.services.UserService;

@Controller
public class HomeController {
	@Autowired
	private DogService dService;
	@Autowired
	private TagService tService;
	@Autowired
	private ToyService toyService;
	@Autowired
	private UserService uService;
	
	@GetMapping("/")
	public String index(Model viewModel) {
		List<User> user = this.uService.allUsers();
		viewModel.addAttribute("users", user);
		return "landing.jsp";
	}
	
	@PostMapping("/login")
	public String login(HttpSession session, @RequestParam("userToBeLoggedIn") Long id) {
		if(session.getAttribute("user__id") == null) {
			session.setAttribute("user__id", id);
		}
		return "redirect:/dogs";
	}
	
	@GetMapping("/dogs")
	public String dashboard(Model viewModel, HttpSession session) {
		Long userId = (Long)session.getAttribute("user__id");
		System.out.println(userId);
		User user = this.uService.find(userId);
		List<Dog> dogs = this.dService.getAllPets();
		viewModel.addAttribute("allDogs", dogs);
		viewModel.addAttribute("user", user);
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
	
	// Show Page
	@GetMapping("/{id}")
	public String show(@PathVariable("id") Long id, Model viewModel, @ModelAttribute("tag") Tag tag) {
		viewModel.addAttribute("dog", this.dService.getOneDog(id));
		return "show.jsp";
	}
	
	@PostMapping("/tag/{id}")
	public String addTag(@Valid @ModelAttribute("tag") Tag tag, BindingResult result, @PathVariable("id") Long id, Model viewModel) {
		if(result.hasErrors()) {
			viewModel.addAttribute("dog", this.dService.getOneDog(id));
			return "show.jsp";
		}
		Dog dogTagBelongsTo = this.dService.getOneDog(id);
		tag.setDog(dogTagBelongsTo);
		this.tService.create(tag);
		return "redirect:/" + id; 
		
	}
	
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable("id") Long id) {
		this.dService.deleteDog(id);
		return "redirect:/";
	}
	
	@GetMapping("/edit/{id}")
	public String edit(@ModelAttribute("dog") Dog dog, Model viewModel, @PathVariable("id") Long id) {
		viewModel.addAttribute("dog", this.dService.getOneDog(id));
		return "edit.jsp";
	}
	
	@PostMapping("/edit/{id}")
	public String postEdit(@Valid @ModelAttribute("dog") Dog dog, BindingResult result, Model viewModel, @PathVariable("id") Long id) {
		if(result.hasErrors()) {
			viewModel.addAttribute("dog", this.dService.getOneDog(id));
			return "edit.jsp";
		}
		this.dService.updateDog(id, dog);
		return "redirect:/";
	}
	
	@GetMapping("/new")
	public String createToy(@ModelAttribute("toy") Toy toy, Model viewModel) {
		viewModel.addAttribute("allDogs", this.dService.getAllPets());
		return "toys/new.jsp";
	}
	
	@PostMapping("/new")
	public String create(@Valid @ModelAttribute("toy") Toy toy, BindingResult result, Model viewModel) {
		if(result.hasErrors()) {
			viewModel.addAttribute("allDogs", this.dService.getAllPets());
		}
		this.toyService.create(toy);
		return "redirect:/";
	}
	
	@GetMapping("/like/{id}")
	public String like(@PathVariable("id") Long id, HttpSession session) {
		Long userId = (Long)session.getAttribute("user__id");
		Long petId = id;
		User liker = this.uService.find(userId);
		Dog likedDog = this.dService.getOneDog(petId);
		this.dService.addLiker(liker, likedDog);
		return "redirect:/dogs";
	}
	
	@GetMapping("/unlike/{id}")
	public String unlike(@PathVariable("id") Long id, HttpSession session) {
		Long userId = (Long)session.getAttribute("user__id");
		Long petId = id;
		User liker = this.uService.find(userId);
		Dog likedDog = this.dService.getOneDog(petId);
		this.dService.removeLiker(liker, likedDog);
		return "redirect:/dogs";
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}
}
