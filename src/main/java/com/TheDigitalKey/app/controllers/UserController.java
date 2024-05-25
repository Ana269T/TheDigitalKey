package com.TheDigitalKey.app.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.ui.Model;

import com.TheDigitalKey.app.Repositorys.IUserRepository;
import com.TheDigitalKey.app.bd.User;

//import ch.qos.logback.core.model.Model;

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
		System.out.println("Intento de inicio de sesión");

		if (username.equals("adm@gmail.com") && password.equals("123")) {
			return "redirect:/hotel/hotels";
		}

		try {
			Optional<User> user = userRepository.findByUsername(username);
			User userSession = user.get();
			if (username.equals(userSession.getUsername()) && password.equals(userSession.getPassword())) {
				return "redirect:/hotel/hotels-homepage";

			} else {
				System.out.println("no esta registrado");
				// Agrega un mensaje de error al modelo para mostrarlo en la vista
				model.addAttribute("error", "Usuario o contraseña incorrectos");
				return "login-app";
			}
		} catch (Exception e) {
			System.out.println("Me entra al catch");
			return "redirect:/hotel/hotels-homepage";
		}

	}

	@GetMapping("/login-page")
	public String openLogin(Model model) {
		System.out.println("Entra al Login");
		return "login-app";
	}

}
