package com.project.booking.model;

import com.project.booking.entity.Guest;
import com.project.booking.entity.Reservation;
import com.project.booking.entity.RoomBooking;

public class BookingDetails {
	
	private Guest guest;
	private Reservation reservation;
	private RoomBooking roomBooking;
	
	public Guest getGuest() {
		return guest;
	}
	public void setGuest(Guest guest) {
		this.guest = guest;
	}
	public Reservation getReservation() {
		return reservation;
	}
	public void setReservation(Reservation reservation) {
		this.reservation = reservation;
	}
	public RoomBooking getRoomBooking() {
		return roomBooking;
	}
	public void setRoomBooking(RoomBooking roomBooking) {
		this.roomBooking = roomBooking;
	}
}
