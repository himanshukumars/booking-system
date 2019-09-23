package com.project.booking.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.project.booking.entity.Vendor;

@Repository
public interface VendorRepository extends CrudRepository<Vendor, String> {

}
