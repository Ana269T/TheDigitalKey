package com.TheDigitalKey.bd;

import java.util.List;

import jakarta.persistence.*;


@Entity
@Table(name = "Usuario")

public class Usuario { 
	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 private Long id;
	 
	 @Column(name = "Primer_nombre")
	 private String primer_nombre;

	 @Column(name = "Segundo_nombre")
	 private String segundo_nombre;
	 
	 @Column(name = "Primer_apellido")
	 private String primer_apellido;

     @Column(name = "Segundo_apellido")
	 private int segunso_apellido;
     
     @Column(name = "Cedula")
	 private String cedula;

	 @Column(name = "Correo")
	 private String correo;
	 
	 @Column(name = "Contraseña")
	 private int contrasena;
     
     @Column(name = "Telefono")
	 private String telefono; 
     
    

     // Relación OneToMany con la clase Hotel
     @OneToMany(mappedBy = "usuario")
     private List<Reserva> reservas;

     // Constructor vacío (necesario para JPA)
     public Usuario() {
     }

	public Usuario(Long id, String primer_nombre, String segundo_nombre, String primer_apellido, int segunso_apellido,
			String cedula, String correo, int contrasena, String telefono, List<Reserva> reservas) {
		super();
		this.id = id;
		this.primer_nombre = primer_nombre;
		this.segundo_nombre = segundo_nombre;
		this.primer_apellido = primer_apellido;
		this.segunso_apellido = segunso_apellido;
		this.cedula = cedula;
		this.correo = correo;
		this.contrasena = contrasena;
		this.telefono = telefono;
		this.reservas = reservas;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPrimer_nombre() {
		return primer_nombre;
	}

	public void setPrimer_nombre(String primer_nombre) {
		this.primer_nombre = primer_nombre;
	}

	public String getSegundo_nombre() {
		return segundo_nombre;
	}

	public void setSegundo_nombre(String segundo_nombre) {
		this.segundo_nombre = segundo_nombre;
	}

	public String getPrimer_apellido() {
		return primer_apellido;
	}

	public void setPrimer_apellido(String primer_apellido) {
		this.primer_apellido = primer_apellido;
	}

	public int getSegunso_apellido() {
		return segunso_apellido;
	}

	public void setSegunso_apellido(int segunso_apellido) {
		this.segunso_apellido = segunso_apellido;
	}

	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public int getContrasena() {
		return contrasena;
	}

	public void setContrasena(int contrasena) {
		this.contrasena = contrasena;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public List<Reserva> getReservas() {
		return reservas;
	}

	public void setReservas(List<Reserva> reservas) {
		this.reservas = reservas;
	}

     
 

}





