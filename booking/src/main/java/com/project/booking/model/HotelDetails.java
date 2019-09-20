package com.project.booking.model;

import com.project.booking.entity.Hotel;
import com.project.booking.entity.HotelReview;
import com.project.booking.entity.Room;

public class HotelDetails {

	private Hotel hotel;
	private HotelReview hotelReview;
	private Room room;
	public Integer noOfRoomsAvailable;
	
	public Integer getNoOfRoomsAvailable() {
		return noOfRoomsAvailable;
	}
	public void setNoOfRoomsAvailable(Integer noOfRoomsAvailable) {
		this.noOfRoomsAvailable = noOfRoomsAvailable;
	}
	public Hotel getHotel() {
		return hotel;
	}
	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}
	public HotelReview getHotelReview() {
		return hotelReview;
	}
	public void setHotelReview(HotelReview hotelReview) {
		this.hotelReview = hotelReview;
	}
	public Room getRoom() {
		return room;
	}
	public void setRoom(Room room) {
		this.room = room;
	}
	
	
}
