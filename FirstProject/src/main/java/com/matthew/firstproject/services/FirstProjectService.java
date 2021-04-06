package com.matthew.firstproject.services;

import org.springframework.stereotype.Service;

@Service	
public class FirstProjectService {
	public String sayHello() {
		System.out.println("Hello");
		return "Hello";
	}
}
