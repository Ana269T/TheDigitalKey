package com.TheDigitalKey.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.TheDigitalKey.app.Repositorys.IHabitacionRepository;
import com.TheDigitalKey.app.Repositorys.IHotel;
import com.TheDigitalKey.app.Repositorys.IReserva;
import com.TheDigitalKey.app.bd.Booking;
import com.TheDigitalKey.app.bd.Hotel;
import com.TheDigitalKey.app.bd.Room;


@Controller
@RequestMapping("/booking")
public class BookingCotroller {

	@Autowired
	private IReserva reservaRepository;
	
	@Autowired
	private IHabitacionRepository habitacionRepository;

	@Autowired
	private IHotel hotelRepository;


	@GetMapping("/reserva")
	public String mostrarFormulario(@PathVariable Long id, Model model, @PathVariable Long idHabitacion) {
		Hotel hotel = hotelRepository.findById(id).orElse(null);
		model.addAttribute("hotel", hotel);
		model.addAttribute("rooms", habitacionRepository.findByHotelId(hotel.getId()));
		return "booking";
	}

	@PostMapping("/reserva/{idhotel}/{idroom}")
	public String procesarFormulario(@PathVariable Long idhotel,@PathVariable Long idroom, Booking reserva, @RequestParam String username, @RequestParam String cedula, Room habitacion) {
		
		System.out.println(reserva.getDate_departure());
		System.out.println(reserva.getDate_entry());
		System.out.println(reserva.getDate_departure());
		System.out.println(username);
		System.out.println(cedula);
		Hotel hotel = hotelRepository.findById(idhotel).get();
		Room room = habitacionRepository.findById(idhotel).get();
		habitacion.setId_hotel(hotel);

		habitacionRepository.save(habitacion);
		return "redirect:/hotel/hotels"; // Redireccionar a una página de resultado
	}

}