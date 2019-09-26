package com.project.booking.controller;

import java.util.List;

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

@RestController
@RequestMapping("api/hotel")
public class HotelController {

	@Autowired
	HotelService hotelService;

	@PostMapping("/hotel/info")
	public ResponseEntity<List<HotelDTO>> getHotelDetails(@RequestBody HotelDTO hotelDTO) {

		List<HotelDTO> hotel = null;
		try {

			hotel = hotelService.getHotelDetailsInfo(hotelDTO);
			if (hotel != null)
				return new ResponseEntity<List<HotelDTO>>(hotel, HttpStatus.OK);

		} catch (Exception e) {

		}
		return new ResponseEntity<List<HotelDTO>>(hotel, HttpStatus.BAD_REQUEST);
	}

	@PostMapping("/add")
	public ResponseEntity<String> addHotel(@RequestBody HotelDTO hotelDTO) {

		String responseStatus = hotelService.addHotel(hotelDTO);
		return new ResponseEntity<String>(responseStatus, HttpStatus.OK);
	}

	@PostMapping("/rooms/add")
	public ResponseEntity<String> addRooms(@RequestBody RoomDTO roomDTO) {

		String responseStatus = hotelService.addRoomsToAHotel(roomDTO);
		return new ResponseEntity<String>(responseStatus, HttpStatus.OK);
	}

	@PostMapping("/reviews/comment")
	public ResponseEntity<String> rateAHotel(@RequestBody ReviewDTO review) {

		String responseStatus = hotelService.addRatings(review);
		return new ResponseEntity<String>(responseStatus, HttpStatus.OK);
	}

}
