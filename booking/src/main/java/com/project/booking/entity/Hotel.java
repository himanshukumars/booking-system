package com.project.booking.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.GenericGenerator;

@Entity
public class Hotel {

	@Id
	@GenericGenerator(name = "hotelId", strategy = "com.project.booking.util.HotelIdGenerator")
	@GeneratedValue(generator = "hotelId")
	private String hotelId;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "location_id")
	@Fetch(FetchMode.JOIN)
	private Location location;

	private String hotelName;

	@ManyToMany
	@JoinTable(name = "hotel_vendors", joinColumns = @JoinColumn(name = "hotel_id"), inverseJoinColumns = @JoinColumn(name = "vendor_id"))
	private List<Vendor> hotelVendors;

	private String address;
	private String phoneNumber;
	private String alternatePhoneNumber;
	private String checkInTime;
	private String checkOutTime;

	@OneToMany(targetEntity = Room.class, mappedBy = "hotel", orphanRemoval = false, fetch = FetchType.LAZY)
	private List<Room> rooms;

	@OneToMany(targetEntity = HotelReview.class, mappedBy = "hotel", orphanRemoval = false, fetch = FetchType.LAZY)
	private List<HotelReview> hotelReviews;

	@OneToMany(targetEntity = Reservation.class, mappedBy = "hotel", orphanRemoval = false, fetch = FetchType.LAZY)
	private List<Reservation> hotelReservations;

	public List<HotelReview> getHotelReviews() {
		return hotelReviews;
	}

	public void setHotelReviews(List<HotelReview> hotelReviews) {
		this.hotelReviews = hotelReviews;
	}

	public List<Vendor> getHotelVendors() {
		return hotelVendors;
	}

	public void setHotelVendors(List<Vendor> hotelVendors) {
		this.hotelVendors = hotelVendors;
	}

	public List<Reservation> getHotelReservations() {
		return hotelReservations;
	}

	public void setHotelReservations(List<Reservation> hotelReservations) {
		this.hotelReservations = hotelReservations;
	}

	public List<Room> getRooms() {
		return rooms;
	}

	public void setRooms(List<Room> rooms) {
		this.rooms = rooms;
	}

	public String getHotelId() {
		return hotelId;
	}

	public void setHotelId(String hotelId) {
		this.hotelId = hotelId;
	}

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	public String getHotelName() {
		return hotelName;
	}

	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
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

	public String getAlternatePhoneNumber() {
		return alternatePhoneNumber;
	}

	public void setAlternatePhoneNumber(String alternatePhoneNumber) {
		this.alternatePhoneNumber = alternatePhoneNumber;
	}

	public String getCheckInTime() {
		return checkInTime;
	}

	public void setCheckInTime(String checkInTime) {
		this.checkInTime = checkInTime;
	}

	public String getCheckOutTime() {
		return checkOutTime;
	}

	public void setCheckOutTime(String checkOutTime) {
		this.checkOutTime = checkOutTime;
	}

}
