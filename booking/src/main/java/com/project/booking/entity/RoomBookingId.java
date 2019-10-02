package com.project.booking.entity;

import java.io.Serializable;

public class RoomBookingId implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Room roomType;
	private Reservation reservation;
	
	public Room getRoomType() {
		return roomType;
	}
	public void setRoomType(Room roomType) {
		this.roomType = roomType;
	}
	public Reservation getReservation() {
		return reservation;
	}
	public void setReservation(Reservation reservation) {
		this.reservation = reservation;
	}

}
