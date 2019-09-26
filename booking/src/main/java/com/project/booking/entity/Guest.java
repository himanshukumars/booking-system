package com.project.booking.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;;

@Entity
@SequenceGenerator(initialValue = 1000, name = "UserSeq")
public class Guest {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "UserSeq")
	private Long guestId;
	private String firstName;
	private String lastName;
	private String emailId;
	private String address;
	private String phoneNumber;
	
	@OneToMany(targetEntity = HotelReview.class, mappedBy = "guest", orphanRemoval = false, fetch = FetchType.LAZY)
	List<HotelReview> guestReviews;
	
	@OneToMany(targetEntity = Reservation.class, mappedBy = "guest", orphanRemoval = false, fetch = FetchType.LAZY)
	private List<Reservation> reservations;
	

	public Long getGuestId() {
		return guestId;
	}

	public void setGuestId(Long guestId) {
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
