package com.project.booking.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.booking.model.HotelDTO;
import com.project.booking.model.ReviewDTO;
import com.project.booking.model.RoomDTO;
import com.project.booking.service.HotelService;
import com.project.booking.service.IHotelService;
import com.project.booking.util.ApplicationConstants;

@RestController
@RequestMapping("api/hotel")
public class HotelController {
	
	private static final Logger logger = LoggerFactory.getLogger(HotelController.class);
	
	@Autowired
	IHotelService hotelService;

	@PostMapping("/hotel/info")
	public ResponseEntity<List<HotelDTO>> getHotelDetails(@RequestBody HotelDTO hotelDTO) {

		logger.info("Entering Hotel Information controller .. ");
		List<HotelDTO> hotel = null;
		
		try {
			hotel = hotelService.getHotelDetailsInfo(hotelDTO);
			if (hotel != null)
				return new ResponseEntity<List<HotelDTO>>(hotel, HttpStatus.OK);

		} catch (Exception e) {
			logger.error("Error occured while serving requests in getHotelDetails(): " + e.toString());
		}
		return new ResponseEntity<List<HotelDTO>>(hotel, HttpStatus.BAD_REQUEST);
	}

	@PostMapping("/add")
	public ResponseEntity<String> addHotel(@RequestBody HotelDTO hotelDTO) {

		logger.info("Entering Hotel Add controller .. ");
		
		try {
			String responseStatus = hotelService.addHotel(hotelDTO);
			return new ResponseEntity<String>(responseStatus, HttpStatus.OK);
		
		}catch(Exception e) {
			logger.error("Error occured while serving requests in addHotel(): " + e.toString());
		}
		return new ResponseEntity<String>(ApplicationConstants.FAILED, HttpStatus.BAD_REQUEST);
	}

	@PostMapping("/rooms/add")
	public ResponseEntity<String> addRooms(@RequestBody RoomDTO roomDTO) {

		logger.info("Entering Rooms Add controller .. ");
		
		try {
			String responseStatus = hotelService.addRoomsToAHotel(roomDTO);
			return new ResponseEntity<String>(responseStatus, HttpStatus.OK);
		
		} catch (Exception e) {
			logger.error("Error occured while serving requests in addRooms(): " + e.toString());
		}
		return new ResponseEntity<String>(ApplicationConstants.FAILED, HttpStatus.BAD_REQUEST);
	}

	@PostMapping("/reviews/comment")
	public ResponseEntity<String> rateAHotel(@RequestBody ReviewDTO review) {

		logger.info("Entering Hotel Ratings controller .. ");
		
		try {
			String responseStatus = hotelService.addRatings(review);
			return new ResponseEntity<String>(responseStatus, HttpStatus.OK);
		
		} catch (Exception e) {
			logger.error("Error occured while serving requests in rateAHotel(): " + e.toString());
		}
		return new ResponseEntity<String>(ApplicationConstants.FAILED, HttpStatus.BAD_REQUEST);
	}

}
