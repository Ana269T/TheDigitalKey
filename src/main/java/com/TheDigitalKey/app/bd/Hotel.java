package com.TheDigitalKey.app.bd;

import java.util.List;

import jakarta.persistence.*;

@Entity
@Table(name = "Hotel")

public class Hotel {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "img")
	private String img;

	@Column(name = "name")
	private String name;

	@Column(name = "Address")
	private String address;

	@Column(name = "Department")
	private String department;

	@Column(name = "Phone")
	private String phone;

	@Column(name = "Classification")
	private String classification;

	@Column(name = "State")
	private String state;

	@Column(name = "Swimming_pool")
	private int swimming_pool;

	@Column(name = "wifi")
	private String wifi;

	@ManyToOne
	@JoinColumn(name = "departamento_id", referencedColumnName = "id")
	private Department department_;

	@OneToMany(mappedBy = "hotel")
	private List<Room> room;

	@OneToMany(mappedBy = "hotel")
	private List<booking> reservas;

	public Hotel() {
		super();
	}

	public Hotel(Long id, String img, String name, String address, String department, String phone, String classification,
			String state, int swimming_pool, String wifi, Department department_, List<Room> room,
			List<booking> reservas) {
		super();
		this.id = id;
		this.img = img;
		this.name = name;
		this.address = address;
		this.department = department;
		this.phone = phone;
		this.classification = classification;
		this.state = state;
		this.swimming_pool = swimming_pool;
		this.wifi = wifi;
		this.department_ = department_;
		this.room = room;
		this.reservas = reservas;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public List<Room> getRoom() {
		return room;
	}

	public void setRoom(List<Room> room) {
		this.room = room;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
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

	public List<Room> getHabitaciones() {
		return room;
	}

	public void setHabitaciones(List<Room> habitaciones) {
		this.room = habitaciones;
	}

	public List<booking> getReservas() {
		return reservas;
	}

	public void setReservas(List<booking> reservas) {
		this.reservas = reservas;
	}

}
