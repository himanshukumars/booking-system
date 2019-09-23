package com.project.booking.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.project.booking.entity.Guest;
import java.lang.String;
import java.util.List;

@Repository
public interface GuestRepository extends CrudRepository<Guest, Long> {

	List<Guest> findByEmailId(String emailid);
	List<Guest> findByPhoneNumber(String phonenumber);
}
