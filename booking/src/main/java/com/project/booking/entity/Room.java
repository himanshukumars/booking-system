package com.project.booking.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.GenericGenerator;

@Entity
@SequenceGenerator(name = "RoomSeq", initialValue = 2000)
public class Room {

	@GenericGenerator(name = "roomTypeId", strategy = "com.project.booking.util.RoomTypeGenerator")
	@GeneratedValue(generator = "roomTypeId")
	@Id
	private String roomTypeId;
	private String bedType;
	private Integer noOfPersons;
	private Integer noOfRooms;
	private String roomType;
	private boolean isACRoom;
	private boolean isTVAvailable;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "hotel_id")
	@Fetch(FetchMode.JOIN)
	private Hotel hotel;

	@OneToMany(targetEntity = RoomBooking.class, mappedBy = "roomType", orphanRemoval = false, fetch = FetchType.LAZY)
	private List<RoomBooking> roomsBooked;

	public Integer getNoOfRooms() {
		return noOfRooms;
	}

	public void setNoOfRooms(Integer noOfRooms) {
		this.noOfRooms = noOfRooms;
	}

	public String getRoomTypeId() {
		return roomTypeId;
	}

	public void setRoomTypeId(String roomTypeId) {
		this.roomTypeId = roomTypeId;
	}

	public Hotel getHotel() {
		return hotel;
	}

	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}

	public String getBedType() {
		return bedType;
	}

	public void setBedType(String bedType) {
		this.bedType = bedType;
	}

	public Integer getNoOfPersons() {
		return noOfPersons;
	}

	public void setNoOfPersons(Integer noOfPersons) {
		this.noOfPersons = noOfPersons;
	}

	public String getRoomType() {
		return roomType;
	}

	public void setRoomType(String roomType) {
		this.roomType = roomType;
	}

	public boolean getIsACRoom() {
		return isACRoom;
	}

	public void setIsACRoom(boolean isACRoom) {
		this.isACRoom = isACRoom;
	}

	public boolean getIsTVAvailable() {
		return isTVAvailable;
	}

	public void setIsTVAvailable(boolean isTVAvailable) {
		this.isTVAvailable = isTVAvailable;
	}
	public List<RoomBooking> getRoomsBooked() {
		return roomsBooked;
	}

	public void setRoomsBooked(List<RoomBooking> roomsBooked) {
		this.roomsBooked = roomsBooked;
	}

	public void setACRoom(boolean isACRoom) {
		this.isACRoom = isACRoom;
	}

	public void setTVAvailable(boolean isTVAvailable) {
		this.isTVAvailable = isTVAvailable;
	}

}
