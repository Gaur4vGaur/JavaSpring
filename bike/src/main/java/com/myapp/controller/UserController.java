package com.myapp.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import com.myapp.repositories.interfaces.IUserRepository;
import com.myapp.models.User;

import java.util.List;


@RestController
@RequestMapping("api/v1/user")
public class UserController {

	@Autowired
	IUserRepository<User> userRepository;

	// http://localhost:8080/api/v1/user/1
	@GetMapping("/{id}")
	public User user(@PathVariable("id") Long id) {
		return userRepository.user(id);
	}

	// mutiple users to describe
	@GetMapping
	public List<User> users() {
		return userRepository.users();
	}

	@PostMapping("/create")
	@ResponseStatus(HttpStatus.OK)
	public void create(@RequestBody List<User> users) {
		userRepository.createUsers(users);
	}

}
