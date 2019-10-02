package com.project.booking.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.project.booking.entity.Room;

@Repository
public interface RoomRepository extends CrudRepository<Room, String> {

	
	

}
