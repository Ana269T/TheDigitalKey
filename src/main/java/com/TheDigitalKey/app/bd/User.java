package com.TheDigitalKey.app.bd;

import java.util.List;
import com.TheDigitalKey.app.bd.Roles;

import jakarta.persistence.*;


@Entity
@Table(name = "Usuario")

public class Usuario { 
	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 private Long id;
	 
	 @Column(name = "nombres")
	 private String nombres;

	 @Column(name = "apellidos")
	 private String apellidos;
     
     @Column(name = "cedula")
	 private String cedula;

	 @Column(name = "correo")
	 private String correo;
	 
	 @Column(name = "contraseña")
	 private int contrasena;
     
     @Column(name = "telefono")
	 private String telefono; 
     
     @ManyToOne
     @JoinColumn(name = "rol_id", referencedColumnName = "id_rol")
     private Roles rol;
    
     @OneToMany(mappedBy = "usuario")
     private List<Reserva> reservas;

     public Usuario() {
     }
     
     


	public Usuario(Long id, String nombres, String apellidos, String cedula, String correo, int contrasena,
			String telefono, Roles rol, List<Reserva> reservas) {
		super();
		this.id = id;
		this.nombres = nombres;
		this.apellidos = apellidos;
		this.cedula = cedula;
		this.correo = correo;
		this.contrasena = contrasena;
		this.telefono = telefono;
		this.rol = rol;
		this.reservas = reservas;
	}




	public Long getId() {
		return id;
	}




	public void setId(Long id) {
		this.id = id;
	}




	public String getNombres() {
		return nombres;
	}




	public void setNombres(String nombres) {
		this.nombres = nombres;
	}




	public String getApellidos() {
		return apellidos;
	}




	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
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




	public Roles getRol() {
		return rol;
	}




	public void setRol(Roles rol) {
		this.rol = rol;
	}




	public List<Reserva> getReservas() {
		return reservas;
	}




	public void setReservas(List<Reserva> reservas) {
		this.reservas = reservas;
	}
	
	


 

}





