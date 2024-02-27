package com.TheDigitalKey.bd;

import java.util.List;

import jakarta.persistence.*;


@Entity
@Table(name = "Habitacion")

public class Habitacion { 
	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 private Long id;
	 
	 @Column(name = "Numero_habitacion")
	 private String numero_habitacion;

	 @Column(name = "tipo_habitacion")
	 private String tipo_habitacion;
	 
	 @Column(name = "Precio_noche")
	 private String precio_noche;

     @Column(name = "Disponibilidad")
	 private int disponibilidad; 
     
     @Column(name = "Detalles")
	 private String detalles;


     // Relación OneToMany con la clase Hotel
     @OneToMany(mappedBy = "habitacion")
     private List<Reserva> reservas;

     // Constructor vacío (necesario para JPA)
     public Habitacion() {
     }

	public Habitacion(Long id, String numero_habitacion, String tipo_habitacion, String precio_noche,
			int disponibilidad, String detalles, List<Reserva> reservas) {
		super();
		this.id = id;
		this.numero_habitacion = numero_habitacion;
		this.tipo_habitacion = tipo_habitacion;
		this.precio_noche = precio_noche;
		this.disponibilidad = disponibilidad;
		this.detalles = detalles;
		this.reservas = reservas;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNumero_habitacion() {
		return numero_habitacion;
	}

	public void setNumero_habitacion(String numero_habitacion) {
		this.numero_habitacion = numero_habitacion;
	}

	public String getTipo_habitacion() {
		return tipo_habitacion;
	}

	public void setTipo_habitacion(String tipo_habitacion) {
		this.tipo_habitacion = tipo_habitacion;
	}

	public String getPrecio_noche() {
		return precio_noche;
	}

	public void setPrecio_noche(String precio_noche) {
		this.precio_noche = precio_noche;
	}

	public int getDisponibilidad() {
		return disponibilidad;
	}

	public void setDisponibilidad(int disponibilidad) {
		this.disponibilidad = disponibilidad;
	}

	public String getDetalles() {
		return detalles;
	}

	public void setDetalles(String detalles) {
		this.detalles = detalles;
	}

	public List<Reserva> getReservas() {
		return reservas;
	}

	public void setReservas(List<Reserva> reservas) {
		this.reservas = reservas;
	}
     
     



}

