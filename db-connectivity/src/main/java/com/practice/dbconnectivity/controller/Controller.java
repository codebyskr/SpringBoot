package com.practice.dbconnectivity.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.practice.dbconnectivity.dao.UserRepository;
import com.practice.dbconnectivity.model.User;

@RestController
public class Controller {

	@Autowired
	UserRepository repo;
	
	@PostMapping("/saveUser")
	public String saveUser(@RequestBody User user) {
		repo.save(user);
		return "success";
	}
	
	@GetMapping("/users")
	public List<User> getAllUsers(){
		return repo.findAll();
	}
	
}
