package com.project.booking.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.project.booking.entity.Location;

@Repository
public interface LocationRepository extends CrudRepository<Location, Long> {

}
