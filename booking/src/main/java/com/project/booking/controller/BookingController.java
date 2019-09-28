package com.project.booking.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.booking.model.BookingDTO;
import com.project.booking.service.BookingService;
import com.project.booking.util.ApplicationConstants;


@RestController
@RequestMapping("api/booking/")
public class BookingController {
	
	private static final Logger logger = LoggerFactory.getLogger(BookingController.class);
	
	@Autowired
	BookingService bookingService;

	@RequestMapping("/reservation/{reservationId}")
	public ResponseEntity<BookingDTO> getBookingInfo(@PathVariable("reservationId") String reservationId) {

		logger.info("Entering Booking Information controller .. ");
		
		try {
			BookingDTO bookings = bookingService.getBookingDetails(reservationId);
			if (bookings != null)
				return new ResponseEntity<BookingDTO>(bookings, HttpStatus.OK);

		} catch (Exception e) {
			logger.error("Error occured while serving requests in getBookingInfo(): " + e.toString());
		}
		return new ResponseEntity<BookingDTO>(new BookingDTO(), HttpStatus.BAD_REQUEST);
	}

	@RequestMapping("/retrieveBookings/guest/{emailId}")
	public ResponseEntity<List<BookingDTO>> getGuestBookings(@PathVariable("emailId") String emailId) {

		logger.info("Entering Bookings Information controller .. ");
		List<BookingDTO> bookings = null;
		
		try {
			bookings = bookingService.getAllBookings(emailId);
			if (bookings != null)
				return new ResponseEntity<List<BookingDTO>>(bookings, HttpStatus.OK);

		} catch (Exception e) {
			logger.error("Error occured while serving requests in getGuestBookings(): " + e.toString());
		}
		return new ResponseEntity<List<BookingDTO>>(bookings, HttpStatus.BAD_REQUEST);
	}
	
	@PostMapping("/transact/book/guest/hotel")
	public ResponseEntity<String> book(@RequestBody BookingDTO bookingDTO) {

		logger.info("Entering Booking controller .. ");
		
		try {
			String bookingId = bookingService.bookAHotel(bookingDTO);
			if (bookingId != null)
				return new ResponseEntity<String>(bookingId, HttpStatus.OK);

		} catch (Exception e) {
			logger.error("Error occured while serving requests in getBookingInfo(): " + e.toString());
		}
		return new ResponseEntity<String>(ApplicationConstants.FAILED, HttpStatus.BAD_REQUEST);
	}
	
}
