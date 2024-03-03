package com.TheDigitalKey.app.bd;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "Roles")

public class Roles {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_rol;
    
    @Column(name = "nombre")
    private String nombre;
    
    @OneToMany(mappedBy = "rol")
    private List<Usuario> usuario;

	public Roles() {
		super();
	}

	public Roles(Long id, String nombre, List<Usuario> usuario) {
		super();
		this.id_rol = id;
		this.nombre = nombre;
		this.usuario = usuario;
	}

	public Long getId() {
		return id_rol;
	}

	public void setId(Long id) {
		this.id_rol = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<Usuario> getUsuario() {
		return usuario;
	}

	public void setUsuario(List<Usuario> usuario) {
		this.usuario = usuario;
	}
	
    
}
