package com.project.booking.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.booking.dao.GuestRepository;
import com.project.booking.dao.HotelRepository;
import com.project.booking.dao.HotelReviewRepository;
import com.project.booking.dao.LocationRepository;
import com.project.booking.dao.RoomRepository;
import com.project.booking.dao.VendorRepository;
import com.project.booking.entity.Guest;
import com.project.booking.entity.Hotel;
import com.project.booking.entity.HotelReview;
import com.project.booking.entity.Location;
import com.project.booking.entity.Room;
import com.project.booking.entity.Vendor;
import com.project.booking.model.HotelDTO;
import com.project.booking.model.ReviewDTO;
import com.project.booking.model.RoomDTO;
import com.project.booking.util.ApplicationConstants;

@Service
public class HotelService {

	@Autowired
	private ModelMapper modelMapper;

	@Autowired
	private HotelRepository hotelRepository;

	@Autowired
	LocationRepository locationRepository;

	@Autowired
	GuestRepository guestRepository;
	
	@Autowired
	VendorRepository vendorRepository;

	@Autowired
	RoomRepository roomRepository;

	@Autowired
	HotelReviewRepository hotelReviewRepository;

	public List<HotelDTO> getHotelDetailsInfo(HotelDTO hotelDTO) {
		
		Iterable<Hotel> hotel = null;
		List<Vendor> hotelVendors = new ArrayList<Vendor>();
		List<HotelDTO> list = new ArrayList<HotelDTO>();
		
		try {
			
			if(hotelDTO.getHotelName()!=null)
				hotel = hotelRepository.findByHotelName(hotelDTO.getHotelName());
			
			else if(hotelDTO.getLocationId()!=null) {
				Location location = locationRepository.findById(hotelDTO.getLocationId()).get();
				hotel = hotelRepository.findByLocation(location);
			}
			
			else if(hotelDTO.getVendorId()!=null) {
				
				for(String vId : hotelDTO.getVendorId()) {
					Vendor vendor = vendorRepository.findById(vId).get();
					hotelVendors.add(vendor);
				}
				hotel = hotelRepository.findByHotelVendors(hotelVendors);
			}
			
			for (Hotel h : hotel) {
				hotelDTO = modelMapper.map(h, HotelDTO.class);
				list.add(hotelDTO);
			}
			
		}catch(Exception e) {
			
		}
		
		return list;
	}

	public String addHotel(HotelDTO hotelDTO) {

		try {

			Hotel hotel = modelMapper.map(hotelDTO, Hotel.class);
			if (hotel != null) {
				Location location = locationRepository.findById(hotelDTO.getLocationId()).get();
				hotel.setLocation(location);
				
				hotelRepository.save(hotel);
				return ApplicationConstants.SUCCESS;
			}

		} catch (Exception e) {

		}
		return ApplicationConstants.FAILED;
	}

	public String addRoomsToAHotel(RoomDTO roomDTO) {

		try {
			
			Optional<Hotel> hotelObj = hotelRepository.findById(roomDTO.getHotelId());

			if (roomDTO != null && hotelObj.isPresent()) {
				
				roomDTO.setHotel((Hotel) hotelObj.get());
				Room room = modelMapper.map(roomDTO, Room.class);
				roomRepository.save(room);
				
				return ApplicationConstants.SUCCESS;
			}
		} catch (Exception e) {
		}
		return ApplicationConstants.FAILED;
	}

	public String addRatings(ReviewDTO reviewDTO) {

		try {
			
			Optional<Hotel> hotelObj = hotelRepository.findById(reviewDTO.getHotelId());
			List<Guest> guestObj = guestRepository.findByEmailId(reviewDTO.getEmailId());

			if (reviewDTO != null && hotelObj.isPresent() && guestObj.size()!=0) {
				
				modelMapper.getConfiguration().setAmbiguityIgnored(true);

				HotelReview review = modelMapper.map(reviewDTO, HotelReview.class);
				review.setHotel((Hotel) hotelObj.get());
				review.setLastUpdatedDate(new Date());
				review.setGuest(guestObj.get(0));
				
				hotelReviewRepository.save(review);
				
				return ApplicationConstants.SUCCESS;
			}
		} catch (Exception e) {
		}
		return ApplicationConstants.FAILED;
	}
}
