package com.TheDigitalKey.app.bd;

import java.util.List;

import jakarta.persistence.*;

@Entity
@Table(name = "User")

public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "names")
	private String names;

	@Column(name = "last names")
	private String last_Names;

	@Column(name = "ID_card")
	private String card;

	@Column(name = "user name", unique = true)
	private String username;

	@Column(name = "password")
	private String password;

	@Column(name = "phone")
	private String phone;

	private String role;

	@OneToMany(mappedBy = "usuario")
	private List<booking> booking;

	public User() {
		super();
	}

	public User(Long id, String names, String last_Names, String card, String username, String password, String phone,
			String role, List<com.TheDigitalKey.app.bd.booking> booking) {
		super();
		this.id = id;
		this.names = names;
		this.last_Names = last_Names;
		this.card = card;
		this.username = username;
		this.password = password;
		this.phone = phone;
		this.role = role;
		this.booking = booking;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNames() {
		return names;
	}

	public void setNames(String names) {
		this.names = names;
	}

	public String getLast_Names() {
		return last_Names;
	}

	public void setLast_Names(String last_Names) {
		this.last_Names = last_Names;
	}

	public String getCard() {
		return card;
	}

	public void setCard(String card) {
		this.card = card;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public List<booking> getBooking() {
		return booking;
	}

	public void setBooking(List<booking> booking) {
		this.booking = booking;
	}

	@Override
	public String toString() {
		return "User{" +
				"id=" + id +
				", names='" + names + '\'' +
				", last_Names='" + last_Names + '\'' +
				", card='" + card + '\'' +
				", username='" + username + '\'' +
				", password='" + password + '\'' +
				", phone='" + phone + '\'' +
				", role='" + role + '\'' +
				", booking=" + booking +
				'}';
	}

}
