package com.project.booking.service;

import com.project.booking.entity.Guest;
import com.project.booking.model.UserDTO;

public interface IUserService {

	public UserDTO getGuestInfo(String email);
	public String registerUser(Guest guest);
	
	
}
