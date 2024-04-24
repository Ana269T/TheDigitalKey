package com.TheDigitalKey.app.bd;

import java.util.List;


import jakarta.persistence.*;


@Entity
@Table(name = "Room")

public class Room { 
	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 private Long id;
	 
	 @Column(name = "Room_number")
	 private String room_number;

	 @Column(name = "Room_type")
	 private String room_type;
	 
	 @Column(name = "Price_night")
	 private String price_night;

     @Column(name = "Availability")
	 private int availability; 
     
     @Column(name = "Details")
	 private String Details;

     
     @OneToMany(mappedBy = "room")
     private List<booking> booking;

     @ManyToOne
     @JoinColumn(name = "hotel_id" , referencedColumnName = "id")
     private Hotel hotel;

	public Room() {
		super();
	}

	public Room(Long id, String room_number, String room_type, String price_night, int availability, String details,
			List<com.TheDigitalKey.app.bd.booking> booking, Hotel id_hotel) {
		super();
		this.id = id;
		this.room_number = room_number;
		this.room_type = room_type;
		this.price_night = price_night;
		this.availability = availability;
		Details = details;
		this.booking = booking;
		this.hotel = id_hotel;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getRoom_number() {
		return room_number;
	}

	public void setRoom_number(String room_number) {
		this.room_number = room_number;
	}

	public String getRoom_type() {
		return room_type;
	}

	public void setRoom_type(String room_type) {
		this.room_type = room_type;
	}

	public String getPrice_night() {
		return price_night;
	}

	public void setPrice_night(String price_night) {
		this.price_night = price_night;
	}

	public int getAvailability() {
		return availability;
	}

	public void setAvailability(int availability) {
		this.availability = availability;
	}

	public String getDetails() {
		return Details;
	}

	public void setDetails(String details) {
		Details = details;
	}

	public List<booking> getBooking() {
		return booking;
	}

	public void setBooking(List<booking> booking) {
		this.booking = booking;
	}

	public Hotel getId_hotel() {
		return hotel;
	}

	public void setId_hotel(Hotel id_hotel) {
		this.hotel = id_hotel;
	}
	



}

