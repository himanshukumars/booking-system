package com.project.booking.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.booking.dao.HotelRepository;
import com.project.booking.entity.Hotel;
import com.project.booking.model.HotelDetails;

@Service
public class BookingService {
	
	@Autowired
	HotelRepository hotelRepository;

	public List<HotelDetails> getHotelDetailsInfo(String hotelName) {
		
		List<Hotel> hotels=null;
		List<HotelDetails> listOfHotels = new ArrayList<HotelDetails>();
		
		try {
			
		}catch(Exception e) {
			
		}
		return listOfHotels;
		
	}
	
	
}
