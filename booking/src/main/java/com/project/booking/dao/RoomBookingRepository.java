package com.project.booking.dao;

import java.io.Serializable;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.project.booking.entity.RoomBooking;

@Repository
public interface RoomBookingRepository extends CrudRepository<RoomBooking, Serializable> {

}
