package com.project.booking.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.JoinColumn;;

@Entity
@SequenceGenerator(initialValue = 1000, name = "UserSeq")
public class Guest {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "UserSeq")
	private Integer guestId;
	private String firstName;
	private String lastName;
	private String emailId;
	private String address;
	
	private String phoneNumber;
	
	@ManyToMany
	@JoinTable(
			  name = "guest_review", 
			  joinColumns = @JoinColumn(name = "guest_id"), 
			  inverseJoinColumns = @JoinColumn(name = "room_type_id"))
	List<HotelReview> guestReviews;
	
	@OneToMany(targetEntity = Reservation.class, mappedBy = "guest_id", orphanRemoval = false, fetch = FetchType.LAZY)
	private List<Reservation> reservations;
	

	public Integer getGuestId() {
		return guestId;
	}

	public void setGuestId(Integer guestId) {
		this.guestId = guestId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public List<HotelReview> getReviews() {
		return guestReviews;
	}

	public void setReviews(List<HotelReview> guestReviews) {
		this.guestReviews = guestReviews;
	}
	
}