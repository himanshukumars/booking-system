package com.project.booking.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.project.booking.entity.HotelReview;

@Repository
public interface HotelReviewRepository extends CrudRepository<HotelReview, Long>{

}
