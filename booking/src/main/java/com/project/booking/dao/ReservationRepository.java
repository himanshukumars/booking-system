package com.project.booking.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.project.booking.entity.Reservation;
import com.project.booking.entity.Guest;
import java.util.List;

@Repository
public interface ReservationRepository extends CrudRepository<Reservation, String> {

	List<Reservation> findByGuest(Guest guest);
	Reservation findByReservationIdAndGuest(String reservationId, Guest guest);
}
