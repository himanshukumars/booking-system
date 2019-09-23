package com.project.booking.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity
@SequenceGenerator(name = "RoomSeq", initialValue = 2000)
public class Room {

	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "RoomSeq")
	@Id
	private String roomTypeId;
	private String bedType;
	private Integer noOfPersons;
	private Integer noOfRooms;
	private String roomType;
	private Boolean isACRoom;
	private Boolean isTVAvailable;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "hotel_id", insertable = false, updatable = false)
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

	public Boolean getIsACRoom() {
		return isACRoom;
	}

	public void setIsACRoom(Boolean isACRoom) {
		this.isACRoom = isACRoom;
	}

	public Boolean getIsTVAvailable() {
		return isTVAvailable;
	}

	public void setIsTVAvailable(Boolean isTVAvailable) {
		this.isTVAvailable = isTVAvailable;
	}

}
