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
	public String mostrarFormulario(User user){
		return "registro";
	}
	
	@PostMapping("/register")
	public String RegistroFormulario(User user){
		System.out.print("inicio de registro");
		//user.setPassword(passwordEncoder.encode(user.getPassword()));
		user.setRole("ROLE_USER");
		userRepository.save(user);
		return "redirect:/";
	}
		
	@GetMapping("/login")
	public String loginUsuario(@RequestParam String username, @RequestParam String password, Model model){
		System.out.print("Entro al login");
		Optional <User> user = userRepository.findByUsername(username);
		if (username.equals(user.get().getUsername())&& password == user.get().getPassword()) {
			System.out.print("Datos coinciden");
		}else {
			System.out.print("Error en los datos de ingreso");
		}
		return "login";
	}

}
