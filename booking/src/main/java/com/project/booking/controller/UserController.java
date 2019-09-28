package com.project.booking.controller;

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

import com.project.booking.entity.Guest;
import com.project.booking.model.UserDTO;
import com.project.booking.service.UserService;
import com.project.booking.util.ApplicationConstants;

@RestController
@RequestMapping("api/guest")
public class UserController {
	
	private static final Logger logger = LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	UserService userService;

	@RequestMapping("/{emailId}")
	public ResponseEntity<UserDTO> getUser(@PathVariable("emailId") String emailId) {
		
		logger.info("Entering User Information controller .. ");
		
		try {
			UserDTO userDTO = userService.getGuestInfo(emailId);
			if (userDTO != null)
				return new ResponseEntity<UserDTO>(userDTO, HttpStatus.OK);

		} catch (Exception e) {
			logger.error("Error occured while serving requests in addRooms(): " + e.toString());
		}
		return new ResponseEntity<UserDTO>(new UserDTO(), HttpStatus.BAD_REQUEST);
	}
	
	@PostMapping("/register")
	public ResponseEntity<String> registerUser(@RequestBody Guest guest) {

		logger.info("Entering Register User controller .. ");
		
		try {
			String responseStatus = userService.registerUser(guest);
			return new ResponseEntity<String>(responseStatus, HttpStatus.OK);
		
		} catch (Exception e) {
			logger.error("Error occured while serving requests in addRooms(): " + e.toString());
		}
		return new ResponseEntity<String>(ApplicationConstants.FAILED, HttpStatus.BAD_REQUEST);
	}
	
}
