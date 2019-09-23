package com.project.booking.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.project.booking.entity.Reservation;

@Repository
public interface ReservationRepository extends CrudRepository<Reservation, String> {

}
