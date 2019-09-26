package com.project.booking.service;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.booking.dao.GuestRepository;
import com.project.booking.entity.Guest;
import com.project.booking.model.UserDTO;
import com.project.booking.util.ApplicationConstants;

@Service
public class UserService {

	@Autowired
	GuestRepository guestRepository;
	
	@Autowired
	ModelMapper modelMapper;
	
	public UserDTO getGuestInfo(String email) {
		
		try {
			List<Guest> guests = guestRepository.findByEmailId(email);
			return modelMapper.map(guests.get(0), UserDTO.class);
			
		}catch(Exception e) {
			
		}
		
		return null;
	}
	
	public String registerUser(Guest guest) {

		try {
			if (guest != null) {

				List<Guest> userByEmail = guestRepository.findByEmailId(guest.getEmailId());
				List<Guest> userByPhone = guestRepository.findByPhoneNumber(guest.getPhoneNumber());

				if (userByPhone.isEmpty() && userByEmail.isEmpty()) {
					guestRepository.save(guest);
					return ApplicationConstants.SUCCESS;
				}
			}
		} catch (Exception e) {

		}
		return ApplicationConstants.FAILED;
	}
	
	
}
