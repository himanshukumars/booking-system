package com.project.booking.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity
public class RoomBooking implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer bookedRoomId;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "room_type_id")
	@Fetch(FetchMode.JOIN)
	private Room roomType;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "reservation_id")
	@Fetch(FetchMode.JOIN)
	private Reservation reservation;

	private Integer noOfRooms;

	public Room getRoomType() {
		return roomType;
	}

	public void setRoomType(Room roomType) {
		this.roomType = roomType;
	}

	public Integer getNoOfRooms() {
		return noOfRooms;
	}

	public void setNoOfRooms(Integer noOfRooms) {
		this.noOfRooms = noOfRooms;
	}

	public Reservation getReservation() {
		return reservation;
	}

	public void setReservation(Reservation reservation) {
		this.reservation = reservation;
	}

	public Integer getBookedRoomId() {
		return bookedRoomId;
	}

	public void setBookedRoomId(Integer bookedRoomId) {
		this.bookedRoomId = bookedRoomId;
	}

}
