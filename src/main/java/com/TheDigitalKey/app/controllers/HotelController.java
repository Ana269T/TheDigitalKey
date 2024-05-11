package com.TheDigitalKey.app.controllers;

import java.awt.SystemColor;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.TheDigitalKey.app.Repositorys.IHabitacionRepository;
import com.TheDigitalKey.app.Repositorys.IHotel;
import com.TheDigitalKey.app.bd.Hotel;
import com.TheDigitalKey.app.bd.Room;
import com.TheDigitalKey.config.CloudinaryConfig;
import com.cloudinary.utils.ObjectUtils;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.Image;
import com.itextpdf.text.List;
import com.itextpdf.text.ListItem;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

@Controller
@RequestMapping("/hotel")
public class HotelController {
	
	

	@Autowired
	private IHotel hotelRepository;

	@Autowired
	private IHabitacionRepository habitacionRepository;

	@GetMapping("/registrohotel")
	public String formularioHotel(Hotel hotel, Model model) {
		System.out.print("entra");
		return "hotel";
	}

	@PostMapping("/registrohotel")
	public String guardarRegistroHotel(Hotel hotel) {
		System.out.print("Ingreso al metodo de guardado");
		hotelRepository.save(hotel);
		return "redirect:/hotel/hotels";
	}

	@GetMapping("/hotels")
	public String guardarRegistroHabitacion(Model model) {
		model.addAttribute("hotels", hotelRepository.findAll());
		return "hotel-list";
	}

	@GetMapping("/{id}/room")
	public String guardarHabitacion(@PathVariable Long id,Room habitacion, Model model) {
		System.out.println("Ingreso al metodo de guardado de habitacion");
		System.out.println("Id del hotel: " + id);
		model.addAttribute("hotel", hotelRepository.findById(id).get());
		return "habitacion";
	}


	@PostMapping("/{id}/room")
	public String guardarHabitacion(@PathVariable Long id, Room  habitacion) {
		System.out.println("Ingreso al metodo de BUSCANDO de habitacion");
		System.out.println("Id del hotel: " + id);

		Hotel hotel = hotelRepository.findById(id).get();
		habitacion.setId_hotel(hotel);

		habitacionRepository.save(habitacion);
		return "redirect:/hotel/hotels";
	}
	


	
}