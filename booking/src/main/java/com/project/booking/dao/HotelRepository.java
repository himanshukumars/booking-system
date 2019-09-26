package com.project.booking.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.project.booking.entity.Hotel;
import java.lang.String;
import java.util.List;
import com.project.booking.entity.Location;

@Repository
public interface HotelRepository extends CrudRepository<Hotel, String> {

	List<Hotel> findByHotelName(String hotelname);
	List<Hotel> findByLocation(Location location);
	List<Hotel> findByHotelVendors(List hotelvendors);
}


