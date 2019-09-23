package com.project.booking.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.booking.model.HotelDetails;
import com.project.booking.service.BookingService;

@RestController
@RequestMapping("booking/api")
public class BookingController {

	@Autowired
	BookingService bookingService;

	@RequestMapping("/hotel/{hotelName}")
	public ResponseEntity<List<HotelDetails>> getHotelDetails(@PathVariable("hotelName") String hotelName) {
		
		List<HotelDetails> hotel = null;
		try {

			hotel = bookingService.getHotelDetailsInfo(hotelName);
			if (hotel != null)
				return new ResponseEntity<List<HotelDetails>>(hotel, HttpStatus.OK);

		} catch (Exception e) {

		}
		return new ResponseEntity<List<HotelDetails>>(hotel, HttpStatus.BAD_REQUEST);
	}
	/*
	 * @RequestMapping("/user/{emailId}") public ResponseEntity<Guest>
	 * getUser(@PathVariable("emailId") String emailId) { try {
	 * 
	 * Guest guest = bookingService.getGuestInfo(emailId); if (guest != null) return
	 * new ResponseEntity<Guest>(guest, HttpStatus.OK);
	 * 
	 * } catch (Exception e) {
	 * 
	 * } return new ResponseEntity<Guest>(new Guest(), HttpStatus.BAD_REQUEST); }
	 * 
	 * @RequestMapping(
	 * "checkIn/{inDate}/checkOut/{outDate}/location/{city}/{state}/{country}")
	 * public ResponseEntity<List<HotelDetails>>
	 * getHotelDetailsInLocationByDate(@PathVariable("inDate") Date inDate,
	 * 
	 * @PathVariable("city") Date outDate, @PathVariable("city") String
	 * city, @PathVariable("state") String state,
	 * 
	 * @PathVariable("country") String country) {
	 * 
	 * List<HotelDetails> hotels = null; try {
	 * 
	 * hotels = bookingService.getAllHotelDetailsByLocationAndDate(inDate, outDate,
	 * city, state, country); if (hotels != null) return new
	 * ResponseEntity<List<HotelDetails>>(hotels, HttpStatus.OK);
	 * 
	 * } catch (Exception e) {
	 * 
	 * } return new ResponseEntity<List<HotelDetails>>(hotels,
	 * HttpStatus.BAD_REQUEST); }
	 * 
	 * @RequestMapping("vendor/{vendorName}/location/{city}/{state}/{country}")
	 * public ResponseEntity<List<HotelDetails>>
	 * getHotelDetailsInLocationByVendor(@PathVariable("vendorName") String
	 * vendorName,
	 * 
	 * @PathVariable("city") String city, @PathVariable("state") String state,
	 * 
	 * @PathVariable("country") String country) {
	 * 
	 * List<HotelDetails> hotels = null; try {
	 * 
	 * hotels = bookingService.getAllHotelDetailsByVendor(vendorName, city, state,
	 * country); if (hotels != null) return new
	 * ResponseEntity<List<HotelDetails>>(hotels, HttpStatus.OK);
	 * 
	 * } catch (Exception e) {
	 * 
	 * } return new ResponseEntity<List<HotelDetails>>(hotels,
	 * HttpStatus.BAD_REQUEST); }
	 * 
	 * @RequestMapping("guest/{emailId}/reservation/{reservationId}") public
	 * ResponseEntity<BookingDetails> getBookingInfo(@PathVariable("emailId") String
	 * emailId,
	 * 
	 * @PathVariable("reservationId") String reservationId) {
	 * 
	 * try {
	 * 
	 * BookingDetails bookings =
	 * bookingService.getBookingDetails(emailId,reservationId); if (bookings !=
	 * null) return new ResponseEntity<BookingDetails>(bookings, HttpStatus.OK);
	 * 
	 * } catch (Exception e) {
	 * 
	 * } return new ResponseEntity<BookingDetails>(new BookingDetails(),
	 * HttpStatus.BAD_REQUEST); }
	 * 
	 * @RequestMapping("guest/{emailId}") public
	 * ResponseEntity<List<BookingDetails>>
	 * getGuestBookings(@PathVariable("emailId") String emailId,
	 * 
	 * @PathVariable("reservationId") String reservationId) {
	 * 
	 * List<BookingDetails> bookings = null; try {
	 * 
	 * bookings = bookingService.getAllBookings(emailId,reservationId); if (bookings
	 * != null) return new ResponseEntity<List<BookingDetails>>(bookings,
	 * HttpStatus.OK);
	 * 
	 * } catch (Exception e) {
	 * 
	 * } return new ResponseEntity<List<BookingDetails>>(bookings,
	 * HttpStatus.BAD_REQUEST); }
	 */
}
