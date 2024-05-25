package com.TheDigitalKey.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.TheDigitalKey.app.Repositorys.IReserva;
import com.TheDigitalKey.app.bd.booking;

import ch.qos.logback.core.model.Model;

@Controller
@RequestMapping("/booking")
public class BookingCotroller {

	@Autowired
	private IReserva reservaRepository;

	@GetMapping("/")
	public String guardarReserva(Model model) {
		return "booking";
	}

}
