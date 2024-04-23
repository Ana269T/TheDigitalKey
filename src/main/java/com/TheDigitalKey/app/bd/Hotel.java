package com.TheDigitalKey.app.bd;

import jakarta.persistence.*;


@Entity
@Table(name = "Hotel")

public class Hotel { 
	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 private Long id;
	 
	 @Column(name = "name")
	 private String Name;

	 @Column(name = "Address")
	 private String address;
	 
	 @Column(name = "Department")
	 private String department;

     @Column(name = "Phone")
	 private int phone;
     
     @Column(name = "Classification")
	 private String classification;

	 @Column(name = "State")
	 private String state;
	 
	 @Column(name = "Swimming_pool")
	 private int swimming_pool;
     
     @Column(name = "wifi")
	 private String wifi;

     // Definición de la relación ManyToOne con la entidad Departamento
     @ManyToOne
     @JoinColumn(name = "departamento_id", referencedColumnName = "id")
     private Department department_;

	public Hotel() {
		super();
	}

	public Hotel(Long id, String name, String address, String department, int phone, String classification,
			String state, int swimming_pool, String wifi, Department department_) {
		super();
		this.id = id;
		Name = name;
		this.address = address;
		this.department = department;
		this.phone = phone;
		this.classification = classification;
		this.state = state;
		this.swimming_pool = swimming_pool;
		this.wifi = wifi;
		this.department_ = department_;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public int getPhone() {
		return phone;
	}

	public void setPhone(int phone) {
		this.phone = phone;
	}

	public String getClassification() {
		return classification;
	}

	public void setClassification(String classification) {
		this.classification = classification;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public int getSwimming_pool() {
		return swimming_pool;
	}

	public void setSwimming_pool(int swimming_pool) {
		this.swimming_pool = swimming_pool;
	}

	public String getWifi() {
		return wifi;
	}

	public void setWifi(String wifi) {
		this.wifi = wifi;
	}

	public Department getDepartment_() {
		return department_;
	}

	public void setDepartment_(Department department_) {
		this.department_ = department_;
	}


    
	  

}
