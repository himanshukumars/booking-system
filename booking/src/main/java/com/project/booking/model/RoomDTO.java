package com.project.booking.model;

import com.project.booking.entity.Hotel;

public class RoomDTO {
	
	private BedType bedType;
	private Integer noOfPersons;
	private Integer noOfRooms;
	private String roomType;
	private Boolean isACRoom;
	private Boolean isTVAvailable;
	private String hotelId;
	private Hotel hotel;
	
	public String getHotelId() {
		return hotelId;
	}
	public void setHotelId(String hotelId) {
		this.hotelId = hotelId;
	}
	public BedType getBedType() {
		return bedType;
	}
	public void setBedType(BedType bedType) {
		this.bedType = bedType;
	}
	public Integer getNoOfPersons() {
		return noOfPersons;
	}
	public void setNoOfPersons(Integer noOfPersons) {
		this.noOfPersons = noOfPersons;
	}
	public Integer getNoOfRooms() {
		return noOfRooms;
	}
	public void setNoOfRooms(Integer noOfRooms) {
		this.noOfRooms = noOfRooms;
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
	public Hotel getHotel() {
		return hotel;
	}
	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}
	
	

}
