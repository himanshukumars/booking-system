package com.project.booking.entity;

import java.sql.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.GenericGenerator;

import com.project.booking.model.PaymentStatus;
import com.project.booking.model.ReservationStatus;

@Entity
public class Reservation {

	@Id
	@GenericGenerator(name = "reservationId", strategy = "com.project.booking.util.ReservationIdGenerator")
	@GeneratedValue(generator = "reservationId")
	private String reservationId;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "hotel_id", insertable = false, updatable = false)
	@Fetch(FetchMode.JOIN)
	private Hotel hotel;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "guest_id", insertable = false, updatable = false)
	@Fetch(FetchMode.JOIN)
	private Guest guest;
	
	private PaymentStatus paymentStatus;
	private ReservationStatus reservationStatus;
	private String requests;
	private Date checkInDate;
	private Date checkOutDate;
	
	@OneToMany(targetEntity = RoomBooking.class, mappedBy = "reservation", orphanRemoval = false, fetch = FetchType.LAZY)
	private List<RoomBooking> roomsBooked;

	public String getReservationId() {
		return reservationId;
	}

	public void setReservationId(String reservationId) {
		this.reservationId = reservationId;
	}

	public Guest getGuest() {
		return guest;
	}

	public void setGuest(Guest guest) {
		this.guest = guest;
	}

	public PaymentStatus getPaymentStatus() {
		return paymentStatus;
	}

	public void setPaymentStatus(PaymentStatus paymentStatus) {
		this.paymentStatus = paymentStatus;
	}

	public ReservationStatus getReservationStatus() {
		return reservationStatus;
	}

	public void setReservationStatus(ReservationStatus reservationStatus) {
		this.reservationStatus = reservationStatus;
	}

	public String getRequests() {
		return requests;
	}

	public void setRequests(String requests) {
		this.requests = requests;
	}

	public Hotel getHotel() {
		return hotel;
	}

	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}

	public Date getCheckInDate() {
		return checkInDate;
	}

	public void setCheckInDate(Date checkInDate) {
		this.checkInDate = checkInDate;
	}

	public Date getCheckOutDate() {
		return checkOutDate;
	}

	public void setCheckOutDate(Date checkOutDate) {
		this.checkOutDate = checkOutDate;
	}

}
