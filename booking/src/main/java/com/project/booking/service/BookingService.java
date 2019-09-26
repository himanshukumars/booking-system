package com.project.booking.service;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.booking.dao.GuestRepository;
import com.project.booking.dao.HotelRepository;
import com.project.booking.dao.ReservationRepository;
import com.project.booking.dao.RoomRepository;
import com.project.booking.entity.Guest;
import com.project.booking.entity.Hotel;
import com.project.booking.entity.Reservation;
import com.project.booking.model.BookingDTO;

@Service
public class BookingService {

	@Autowired
	private ModelMapper modelMapper;

	@Autowired
	private HotelRepository hotelRepository;

	@Autowired
	GuestRepository guestRepository;

	@Autowired
	RoomRepository roomRepository;

	@Autowired
	ReservationRepository reservationRepository;

	public BookingDTO getBookingDetails(String emailId, String reservationId) {

		try {
			List<Guest> guest = guestRepository.findByEmailId(emailId);

			if (guest.size() != 0) {
				Reservation reservation = reservationRepository.findByReservationIdAndGuest(reservationId,
						guest.get(0));
				BookingDTO bookingDTO = modelMapper.map(reservation, BookingDTO.class);

				return bookingDTO;
			}
		} catch (Exception e) {

		}
		return null;
	}

	public List<BookingDTO> getAllBookings(String emailId) {

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

		}
		return bookings;
	}

	public String bookAHotel(BookingDTO bookingDTO) {
		
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
			
		}
		return bookingReference;
	}

}
