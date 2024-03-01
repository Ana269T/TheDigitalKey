package com.TheDigitalKey.app.bd;

import jakarta.persistence.*;


@Entity
@Table(name = "Hotel")

public class Hotel { 
	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 private Long id;
	 
	 @Column(name = "Nombre")
	 private String nombre;

	 @Column(name = "Direccion")
	 private String direccion;
	 
	 @Column(name = "Departamento")
	 private String departam;

     @Column(name = "Telefono")
	 private int telefono;
     
     @Column(name = "Clasificacion")
	 private String Clasificacion;

	 @Column(name = "Estado")
	 private String estado;
	 
	 @Column(name = "Piscina")
	 private int piscina;
     
     @Column(name = "wifi")
	 private String wifi;

     // Definición de la relación ManyToOne con la entidad Departamento
     @ManyToOne
     @JoinColumn(name = "departamento_id", referencedColumnName = "id")
     private Departamento departamento;

     // Constructor vacío (necesario para JPA)
     public Hotel() {
     }

	public Hotel(Long id, String nombre, String direccion, String departam, int telefono, String clasificacion,
			String estado, int piscina, String wifi, Departamento departamento) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.direccion = direccion;
		this.departam = departam;
		this.telefono = telefono;
		Clasificacion = clasificacion;
		this.estado = estado;
		this.piscina = piscina;
		this.wifi = wifi;
		this.departamento = departamento;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getDepartam() {
		return departam;
	}

	public void setDepartam(String departam) {
		this.departam = departam;
	}

	public int getTelefono() {
		return telefono;
	}

	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}

	public String getClasificacion() {
		return Clasificacion;
	}

	public void setClasificacion(String clasificacion) {
		Clasificacion = clasificacion;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public int getPiscina() {
		return piscina;
	}

	public void setPiscina(int piscina) {
		this.piscina = piscina;
	}

	public String getWifi() {
		return wifi;
	}

	public void setWifi(String wifi) {
		this.wifi = wifi;
	}

	public Departamento getDepartamento() {
		return departamento;
	}

	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}

    
	  

}
