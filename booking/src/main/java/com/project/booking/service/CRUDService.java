package com.project.booking.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.booking.dao.GuestRepository;
import com.project.booking.dao.HotelRepository;
import com.project.booking.dao.HotelReviewRepository;
import com.project.booking.dao.RoomRepository;
import com.project.booking.entity.Guest;
import com.project.booking.entity.Hotel;
import com.project.booking.entity.HotelReview;
import com.project.booking.entity.Location;
import com.project.booking.entity.Room;
import com.project.booking.util.ApplicationConstants;

@Service
public class CRUDService {
	
	@Autowired
	HotelRepository hotelRepository;
	
	@Autowired
	GuestRepository guestRepository;
	
	@Autowired
	RoomRepository roomRepository;
	
	@Autowired
	HotelReviewRepository hotelReviewRepository;
	
	
	public String addHotel(Hotel hotel) {

		try {
			
			Location loc = hotel.getLocation();
			
			if(hotel!=null) {
				hotelRepository.save(hotel);
				return ApplicationConstants.SUCCESS;
			}			
		}catch(Exception e) {
			
		}
		return ApplicationConstants.FAILED;
	}
	
	public String registerUser(Guest guest) {
				
		try {
			if(guest!=null) {
				
				List<Guest> userByEmail = guestRepository.findByEmailId(guest.getEmailId());
				List<Guest> userByPhone = guestRepository.findByPhoneNumber(guest.getPhoneNumber());
				
				if(userByPhone.isEmpty() && userByEmail.isEmpty()) {
					guestRepository.save(guest);
					return ApplicationConstants.SUCCESS;
				}
			}			
		}catch(Exception e) {
			
		}
		return ApplicationConstants.FAILED;
	}
	
	public String addRoomsToAHotel(String hotelId, Room room) {
		
		try {
			Optional<Hotel> hotelObj = hotelRepository.findById(hotelId);
			
			if(room!=null && hotelObj.isPresent()) {
				
				room.setHotel((Hotel)hotelObj.get());
				roomRepository.save(room);
				return ApplicationConstants.SUCCESS;
			}			
		}catch(Exception e) {
			
		}
		return ApplicationConstants.FAILED;
	}
	
	public String addRatings(String hotelId, HotelReview review) {
		
		try {
			Optional<Hotel> hotelObj = hotelRepository.findById(hotelId);
			
			if(review!=null && hotelObj.isPresent()) {
				
				review.setHotel((Hotel)hotelObj.get());
				hotelReviewRepository.save(review);
				return ApplicationConstants.SUCCESS;
			}			
		}catch(Exception e) {
			
		}
		return ApplicationConstants.FAILED;
	}

}
