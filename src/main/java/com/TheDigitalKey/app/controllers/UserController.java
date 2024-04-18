package com.TheDigitalKey.app.controllers;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.TheDigitalKey.app.Repositorys.IUsuarioRepository;
import com.TheDigitalKey.app.bd.Usuario;

import ch.qos.logback.core.model.Model;

@Controller
@RequestMapping("/usuario")
public class UsuarioController {
	
	@Autowired
	private IUsuarioRepository usuarioRepository;
	
	@GetMapping("/registro")
	public String mostrarFormulario(Usuario usuario){
		return "registro";
	}
	
	@GetMapping("/login")
	public String loginUsuario(@RequestParam String correo, @RequestParam Integer contrasena, Model model){
		System.out.print("Entro al login");
		Optional <Usuario> usuario = usuarioRepository.findByCorreo(correo);
		if (correo.equals(usuario.get().getCorreo())&& contrasena == usuario.get().getContrasena()) {
			System.out.print("Datos coinciden");
		}else {
			System.out.print("Error en los datos de ingreso");
		}
		return "login";
	}

}
