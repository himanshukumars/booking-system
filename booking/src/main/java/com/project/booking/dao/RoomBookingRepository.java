package com.project.booking.dao;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.project.booking.entity.RoomBooking;

@Repository
public interface RoomBookingRepository extends JpaRepository<RoomBooking, Serializable> {

	@Query(value = "select sum(rb.no_of_rooms) from room_booking rb,reservation r where rb.reservation_id=r.reservation_id and r.check_in_date < ':date1' and r.check_out_date > ':date1'",nativeQuery = true)
	public Long sumNoOfRoomsByCheckInDateAndCheckOutDate(@Param("date1") String date1);
	
}
//"
//+ "