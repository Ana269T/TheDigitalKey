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
	private CloudinaryConfig cloudc;

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
	public String guardarHabitacion(@PathVariable Long id, Room habitacion, Model model) {
		System.out.println("Ingreso al metodo de guardado de habitacion");
		System.out.println("Id del hotel: " + id);
		model.addAttribute("hotel", hotelRepository.findById(id).get());
		return "habitacion";
	}

	@PostMapping("/{id}/room")
	public String guardarHabitacion(@PathVariable Long id, Room habitacion) {
		System.out.println("Ingreso al metodo de BUSCANDO de habitacion");
		System.out.println("Id del hotel: " + id);

		Hotel hotel = hotelRepository.findById(id).get();
		habitacion.setId_hotel(hotel);

		habitacionRepository.save(habitacion);
		return "redirect:/hotel/hotels";
	}

	// @GetMapping("")
	// public String addProductoGet(Model model) {
	// return "uploadimage";
	// }

	// @PostMapping("/upload-image")
	// public String addProducto(Model model, @RequestParam("file") MultipartFile
	// file) {

	// try {
	// Map uploadResult = cloudc.upload(file.getBytes(),
	// ObjectUtils.asMap("resourcetype", "auto"));
	// System.out.println(uploadResult.get("url").toString());

	// } catch (Exception e) {
	// System.out.println(e.getMessage());
	// }

	// return "redirect:/";
	// }

	@GetMapping("/open-pdf")
	public String openPDF(Model model) {
		return "pdf";
	}

	@GetMapping("/generate-pdf")
	public ResponseEntity<InputStreamResource> generatePdf() {
		try {
			ByteArrayOutputStream out = new ByteArrayOutputStream();
			Document document = new Document();
			PdfWriter.getInstance(document, out);
			document.open();

			// Agregar un párrafo
			document.add(new Paragraph("Hello World!"));

			// Agregar una lista
			List list = new List(true, false, 10);
			list.add(new ListItem("Primer elemento de la lista"));
			list.add(new ListItem("Segundo elemento de la lista"));
			document.add(list);

			// Agregar una tabla
			PdfPTable table = new PdfPTable(3); // 3 columnas
			table.addCell("Celda 1");
			table.addCell("Celda 2");
			table.addCell("Celda 3");
			table.addCell("Celda 3");
			document.add(table);

			// Agregar una imagen
			Image image = Image.getInstance(
					"https://w7.pngwing.com/pngs/81/570/png-transparent-profile-logo-computer-icons-user-user-blue-heroes-logo-thumbnail.png");
			document.add(image);

			// Agregar un chunk (un fragmento de texto)
			Chunk chunk = new Chunk("Este es un chunk");
			document.add(chunk);

			// Agregar una frase
			Phrase phrase = new Phrase("Esta es una frase");
			document.add(phrase);

			document.close();

			ByteArrayInputStream bis = new ByteArrayInputStream(out.toByteArray());
			return ResponseEntity.ok()
					.contentType(MediaType.APPLICATION_PDF)
					.header("Content-Disposition", "attachment; filename=hello_world.pdf")
					.body(new InputStreamResource(bis));
		} catch (Exception e) {
			return ResponseEntity.status(500).build();
		}
	}

}