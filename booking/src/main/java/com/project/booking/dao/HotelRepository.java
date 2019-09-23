package com.project.booking.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.project.booking.entity.Hotel;

@Repository
public interface HotelRepository extends CrudRepository<Hotel, String> {
	
}


