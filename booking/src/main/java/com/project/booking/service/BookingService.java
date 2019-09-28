package com.project.booking.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.TimeUnit;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.booking.dao.GuestRepository;
import com.project.booking.dao.HotelRepository;
import com.project.booking.dao.ReservationRepository;
import com.project.booking.entity.Guest;
import com.project.booking.entity.Hotel;
import com.project.booking.entity.Reservation;
import com.project.booking.model.BookingDTO;
import com.weddini.throttling.Throttling;
import com.weddini.throttling.ThrottlingType;

@Service
public class BookingService {

	@Autowired
	private ModelMapper modelMapper;

	@Autowired
	private HotelRepository hotelRepository;

	@Autowired
	private GuestRepository guestRepository;

	@Autowired
	private ReservationRepository reservationRepository;
	
	private static final Logger logger = LoggerFactory.getLogger(BookingService.class);

	public BookingDTO getBookingDetails(String reservationId) {

		logger.info("Entering Booking Information service .. ");
		
		try {
			Optional<Reservation> reservationObj = reservationRepository.findById(reservationId);

			if (reservationObj.isPresent()) {
				Reservation reservation = reservationObj.get();
				
				BookingDTO bookingDTO = modelMapper.map(reservation, BookingDTO.class);
				bookingDTO.setHotel(null);

				return bookingDTO;
			}
		} catch (Exception e) {
			logger.error("Error occured while serving requests in getBookingDetails(): " + e.toString());
		}
		return null;
	}

	public List<BookingDTO> getAllBookings(String emailId) {
		
		logger.info("Entering Bookings Information service .. ");

		List<BookingDTO> bookings = new ArrayList<BookingDTO>();

		try {
			List<Guest> guest = guestRepository.findByEmailId(emailId);

			if (guest.size() != 0) {
				List<Reservation> reservations = reservationRepository.findByGuest(guest.get(0));

				for (Reservation r : reservations) {

					BookingDTO bookingDTO = modelMapper.map(r, BookingDTO.class);
					bookings.add(bookingDTO);
				}
			}
		} catch (Exception e) {
			logger.error("Error occured while serving requests in getAllBookings(): " + e.toString());
		}
		return bookings;
	}

	@Throttling(type = ThrottlingType.RemoteAddr, limit = 100, timeUnit = TimeUnit.MINUTES)
	public String bookAHotel(BookingDTO bookingDTO) {
		
		logger.info("Entering Booking service .. ");
		String bookingReference = "";
		
		try {
			List<Guest> guest = guestRepository.findByEmailId(bookingDTO.getEmailId());
			
			if(guest.size()!=0) {
					
				Hotel hotel = hotelRepository.findById(bookingDTO.getHotelId()).get();
				bookingDTO.setHotel(hotel);
				bookingDTO.setGuest(guest.get(0));
				Reservation rs = modelMapper.map(bookingDTO, Reservation.class);
				rs = reservationRepository.save(rs);
				bookingReference = rs.getReservationId();
			}
			
		}catch(Exception e) {
			logger.error("Error occured while serving requests in bookAHotel(): " + e.toString());
		}
		return bookingReference;
	}

}
