package com.project.booking.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.project.booking.entity.Hotel;
import java.lang.String;
import java.util.List;

@Repository
public interface HotelRepository extends CrudRepository<Hotel, Integer> {

	@Query("select * from hotel h inner join h.room r where r.hotelId = ?1")
	public List<Hotel> findByIdRoom(String hotelId);
	
	
}


