package com.TheDigitalKey.app.controllers;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.List;
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
import com.TheDigitalKey.app.Repositorys.IReserva;
import com.TheDigitalKey.app.bd.Hotel;
import com.TheDigitalKey.app.bd.Room;
import com.TheDigitalKey.app.bd.booking;
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
@RequestMapping("/reserva")
public class BookingCotroller {

	@Autowired
	private IReserva reservaRepository;
	
	
	@PostMapping("/")
	public String guardarReserva(booking booking, @RequestParam("file") MultipartFile file) {
	   
	    
	    reservaRepository.save(booking);
	    return "redirect:/hotel/hotels"; 
	}
	
}
	
	