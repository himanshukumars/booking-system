package com.project.booking.service;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.booking.dao.GuestRepository;
import com.project.booking.entity.Guest;
import com.project.booking.model.UserDTO;
import com.project.booking.util.ApplicationConstants;

@Service
public class UserService implements IUserService {

	@Autowired
	private GuestRepository guestRepository;
	
	@Autowired
	private ModelMapper modelMapper;
	
	private static final Logger logger = LoggerFactory.getLogger(UserService.class);
	
	public UserDTO getGuestInfo(String email) {
		
		logger.info("Entering Guest Information service .. ");
		
		try {
			List<Guest> guests = guestRepository.findByEmailId(email);
			return modelMapper.map(guests.get(0), UserDTO.class);
			
		}catch(Exception e) {
			logger.error("Error occured while serving requests in getGuestInfo(): " + e.toString());
		}
		
		return null;
	}
	
	public String registerUser(Guest guest) {
		
		logger.info("Entering Register Guest service .. ");

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
			logger.error("Error occured while serving requests in registerUser(): " + e.toString());
		}
		return ApplicationConstants.FAILED;
	}
	
	
}
