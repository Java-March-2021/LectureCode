package com.matthew.dogs.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.matthew.dogs.models.Dog;
import com.matthew.dogs.models.User;
import com.matthew.dogs.repositories.DogRepository;

@Service
public class DogService {
	private DogRepository dRepo;
	
	
	public DogService(DogRepository repo) {
		this.dRepo = repo;
	}
	
	// getAll
	public List<Dog> getAllPets() {
		return this.dRepo.findAll();
	}
	
	// getOne
	public Dog getOneDog(Long id) {
		return this.dRepo.findById(id).orElse(null);
	}
	
	// createDog
	public Dog createDog(Dog newDog) {
		return this.dRepo.save(newDog);
	}
	
	// Create Dog HTML Forms way
	public Dog createNewDog(String name, String breed, int age) {
		Dog newDog = new Dog(name, breed, age);
		return this.dRepo.save(newDog);
	}
	
	// updateDog
	public Dog updateDog(Long id, Dog updatedDog) {
		return this.dRepo.save(updatedDog);
	}
	
	// Delete Dog
	public void deleteDog(Long id) {
		this.dRepo.deleteById(id);
	}
	
	// Add A Liker
	public void addLiker(User user, Dog dog) {
		// Get the list of the likers that have already liked the dog
		List<User> likers = dog.getLikers();
		// Add The Liker to The List
		likers.add(user);
		// Update The DB
		this.dRepo.save(dog);		 
	}
	
	// Remove A Liker
	public void removeLiker(User user, Dog dog) {
		// Get the list of the likers that have already liked the dog
		List<User> likers = dog.getLikers();
		// Add The Liker to The List
		likers.remove(user);
		// Update The DB
		this.dRepo.save(dog);		 
	}
}
