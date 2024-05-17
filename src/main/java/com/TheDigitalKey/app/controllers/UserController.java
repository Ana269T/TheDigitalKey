package com.TheDigitalKey.app.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.TheDigitalKey.app.Repositorys.IUserRepository;
import com.TheDigitalKey.app.bd.User;

import ch.qos.logback.core.model.Model;

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	private IUserRepository userRepository;

	@GetMapping("/register")
	public String showForm(User user) {
		return "registro";
	}

	@PostMapping("/register")
	public String RegistrationForm(User user) {
		System.out.print("start of registration");
		// user.setPassword(passwordEncoder.encode(user.getPassword()));
		user.setRole("ROLE_USER");
		userRepository.save(user);
		return "redirect:/";
	}

	@GetMapping("/login")
	public String loginUser(@RequestParam String username, @RequestParam String password, Model model) {
		Optional<User> user = userRepository.findByUsername(username);
		User userSession = user.get();
		if (username.equals(userSession.getUsername()) && password.equals(userSession.getPassword())) {
			return "home";
		} else {
			return "login-app";
		}
	}

}
