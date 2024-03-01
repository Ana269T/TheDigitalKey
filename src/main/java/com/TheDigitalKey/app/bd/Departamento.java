package com.TheDigitalKey.app.bd;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "Departamento")
public class Departamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre")
    private String nombre;

    // Relación OneToMany con la clase Hotel
    @OneToMany(mappedBy = "departamento")
    private List<Hotel> hoteles;

    // Constructor vacío (necesario para JPA)
    public Departamento() {
    }

    // Constructor con parámetros
    public Departamento(String nombre) {
        this.nombre = nombre;
    }
    // gets and sets

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

	public List<Hotel> getHoteles() {
		return hoteles;
	}

	public void setHoteles(List<Hotel> hoteles) {
		this.hoteles = hoteles;
	}
    
    
    
    

    
}