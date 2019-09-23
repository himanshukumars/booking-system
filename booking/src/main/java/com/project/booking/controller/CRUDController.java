package com.project.booking.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.booking.entity.Guest;
import com.project.booking.entity.Hotel;
import com.project.booking.entity.HotelReview;
import com.project.booking.entity.Room;
import com.project.booking.service.CRUDService;

@RestController
@RequestMapping("/crud/action/")
public class CRUDController {

	@Autowired
	CRUDService crudService;

	@PostMapping("/hotel/add")
	public ResponseEntity<String> addHotel(@RequestBody Hotel hotel) {
		
		String responseStatus =  crudService.addHotel(hotel);
		return new ResponseEntity<String>(responseStatus, HttpStatus.OK);	
	}
	
	@PostMapping("/guest/register")
	public ResponseEntity<String> registerUser(@RequestBody Guest guest) {
		
		String responseStatus =  crudService.registerUser(guest);
		return new ResponseEntity<String>(responseStatus, HttpStatus.OK);	
	}
	
	@PostMapping("/hotel/{hotelId}/rooms/add")
	public ResponseEntity<String> addRooms(@RequestBody Room room, @PathVariable("hotelId") String hotelId) {
		
		String responseStatus =  crudService.addRoomsToAHotel(hotelId,room);
		return new ResponseEntity<String>(responseStatus, HttpStatus.OK);	
	}
	
	@PostMapping("/hotel/{hotelId}/reviews/comment")
	public ResponseEntity<String> rateAHotel(@RequestBody HotelReview review, @PathVariable("hotelId") String hotelId) {
		
		String responseStatus =  crudService.addRatings(hotelId,review);
		return new ResponseEntity<String>(responseStatus, HttpStatus.OK);	
	}
	
	
}
