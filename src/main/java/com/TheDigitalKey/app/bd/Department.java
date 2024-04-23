package com.TheDigitalKey.app.bd;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "Department")
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    // Relación OneToMany con la clase Hotel
    @OneToMany(mappedBy = "department")
    private List<Hotel> hoteles;

	public Department() {
		super();
	}

	public Department(Long id, String name, List<Hotel> hoteles) {
		super();
		this.id = id;
		this.name = name;
		this.hoteles = hoteles;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Hotel> getHoteles() {
		return hoteles;
	}

	public void setHoteles(List<Hotel> hoteles) {
		this.hoteles = hoteles;
	}

   
    
    
    

    
}