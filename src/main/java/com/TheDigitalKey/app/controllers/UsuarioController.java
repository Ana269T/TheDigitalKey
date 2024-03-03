package com.TheDigitalKey.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.TheDigitalKey.app.Repositorys.IUsuarioRepository;
import com.TheDigitalKey.app.bd.Usuario;

@Controller
@RequestMapping("/usuario")
public class UsuarioController {
	
	@Autowired
	private IUsuarioRepository usuarioRepository;
	
	@GetMapping("/registro")
	public String mostrarFormulario(Usuario usuario){
		return "registro";
	}

}
