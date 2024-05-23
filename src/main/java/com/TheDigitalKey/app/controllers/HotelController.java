package com.TheDigitalKey.app.controllers;

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

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.TheDigitalKey.app.Repositorys.IHabitacionRepository;
import com.TheDigitalKey.app.Repositorys.IHotel;
import com.TheDigitalKey.app.bd.Hotel;
import com.TheDigitalKey.app.bd.Room;
import com.TheDigitalKey.app.config.CloudinaryConfig;
import com.cloudinary.utils.ObjectUtils;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.Image;

import com.itextpdf.text.ListItem;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

@Controller
@RequestMapping("/hotel")
public class HotelController {

	@Autowired
	private CloudinaryConfig cloudc;

	@Autowired
	private IHotel hotelRepository;

	@Autowired
	private IHabitacionRepository habitacionRepository;
	
	@GetMapping("/registrohotel")
	public String formularioHotel(Hotel hotel, Model model) {
		//System.out.print("entra");
		return "hotel";
	}

	@PostMapping("/registrohotel")
	public String guardarRegistroHotel(Hotel hotel, @RequestParam("file") MultipartFile file) {
	    try {
	        Map uploadResult = cloudc.upload(file.getBytes(), ObjectUtils.asMap("resourcetype", "auto"));
	        hotel.setImg(uploadResult.get("url").toString());
	    } catch (Exception e) {
	        System.out.println(e.getMessage());
	    }
	    
	    hotelRepository.save(hotel);
	    return "redirect:/hotel/hotels"; // Redirecciona a la página de lista de hoteles
	}

	
	
	@GetMapping("/details/{id}")
	public String detallesHotel(@PathVariable Long id, Model model) {
	    Hotel hotel = hotelRepository.findById(id).orElse(null);
	    model.addAttribute("hotel", hotel);
	    return "hotel_details";
	}



	@GetMapping("/hotels")
	public String guardarRegistroHabitacion(Model model) {
		model.addAttribute("hotels", hotelRepository.findAll());
		return "hotel_list";
	}

	@GetMapping("/{id}/room")
	public String guardarHabitacion(@PathVariable Long id, Room habitacion, Model model) {
		System.out.println("Ingreso al metodo de guardado de habitacion");
		System.out.println("Id del hotel: " + id);
		model.addAttribute("hotel", hotelRepository.findById(id).get());
		return "room";
	}

	@PostMapping("/{id}/room")
	public String guardarHabitacion(@PathVariable Long id, Room habitacion) {
		System.out.println("Ingreso al metodo de BUSCANDO de habitacion");
		System.out.println("Id del hotel: " + id);

		Hotel hotel = hotelRepository.findById(id).get();
		habitacion.setId_hotel(hotel);

		habitacionRepository.save(habitacion);
		return "redirect:/hotel/details/" + id;
	}

	 @GetMapping("")
	 public String addProductoGet(Model model) {
	 return "uploadimage";
	 }

	 @PostMapping("/upload-image")
	 public String addProducto(Model model, @RequestParam("file") MultipartFile
	 file) {

	 try {
	 Map uploadResult = cloudc.upload(file.getBytes(),
	 ObjectUtils.asMap("resourcetype", "auto"));
	 System.out.println(uploadResult.get("url").toString());

	 } catch (Exception e) {
	 System.out.println(e.getMessage());
	 }

	 return "redirect:/";
	 }

	@GetMapping("/open-pdf")
	public String openPDF(Model model) {
		return "pdf";
	}
	
	// hacer el hotel.getId se hace cuando se seleciona el hotel, para buscar el id del hotel y hacer el registro de la habitacion.
	// esto se hace con el redirect:/hotel.getId
}