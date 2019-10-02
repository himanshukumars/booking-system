package com.project.booking.service;

import java.util.List;

import com.project.booking.model.BookingDTO;

public interface IBookingService {

	public BookingDTO getBookingDetails(String reservationId);
	public List<BookingDTO> getAllBookings(String emailId);
	public String bookAHotel(BookingDTO bookingDTO);
	
	
}
