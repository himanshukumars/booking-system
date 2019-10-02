package com.project.booking.service;

import java.util.List;

import com.project.booking.model.HotelDTO;
import com.project.booking.model.ReviewDTO;
import com.project.booking.model.RoomDTO;

public interface IHotelService {

	public List<HotelDTO> getHotelDetailsInfo(HotelDTO hotelDTO);
	public String addHotel(HotelDTO hotelDTO);
	public String addRoomsToAHotel(RoomDTO roomDTO);
	public String addRatings(ReviewDTO reviewDTO);

}
