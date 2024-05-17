package com.TheDigitalKey.app.bd;

import jakarta.persistence.*;

@Entity
@Table(name = "Booking")

public class booking {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "Date_entry")
	private String date_entry;

	@Column(name = "Date_departure")
	private String date_departure;

	@Column(name = "Reservation_status")
	private String reservation_status;

	@Column(name = "Total_price")
	private int total_price;

	@Column(name = "Payment_form")
	private String payment_form;

	@Column(name = "Cancellation_policy")
	private String cancellation_policy;

	@ManyToOne
	@JoinColumn(name = "user_id", referencedColumnName = "id")
	private User usuario;

	@ManyToOne
	@JoinColumn(name = "room_id", referencedColumnName = "id")
	private Room room;

	@ManyToOne
	@JoinColumn(name = "id_hotel", referencedColumnName = "id")
	private Hotel hotel;

	public booking() {
		super();
	}

	public booking(Long id, String date_entry, String date_departure, String reservation_status, int total_price,
			String payment_form, String cancellation_policy, User user, Room room, Hotel id_hotel) {
		super();
		this.id = id;
		this.date_entry = date_entry;
		this.date_departure = date_departure;
		this.reservation_status = reservation_status;
		this.total_price = total_price;
		this.payment_form = payment_form;
		this.cancellation_policy = cancellation_policy;
		this.usuario = user;
		this.room = room;
		this.hotel = id_hotel;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDate_entry() {
		return date_entry;
	}

	public void setDate_entry(String date_entry) {
		this.date_entry = date_entry;
	}

	public String getDate_departure() {
		return date_departure;
	}

	public void setDate_departure(String date_departure) {
		this.date_departure = date_departure;
	}

	public String getReservation_status() {
		return reservation_status;
	}

	public void setReservation_status(String reservation_status) {
		this.reservation_status = reservation_status;
	}

	public int getTotal_price() {
		return total_price;
	}

	public void setTotal_price(int total_price) {
		this.total_price = total_price;
	}

	public String getPayment_form() {
		return payment_form;
	}

	public void setPayment_form(String payment_form) {
		this.payment_form = payment_form;
	}

	public String getCancellation_policy() {
		return cancellation_policy;
	}

	public void setCancellation_policy(String cancellation_policy) {
		this.cancellation_policy = cancellation_policy;
	}

	public User getUser() {
		return usuario;
	}

	public void setUser(User user) {
		this.usuario = user;
	}

	public Room getRoom() {
		return room;
	}

	public void setRoom(Room room) {
		this.room = room;
	}

	public Hotel getId_hotel() {
		return hotel;
	}

	public void setId_hotel(Hotel id_hotel) {
		this.hotel = id_hotel;
	}
}
