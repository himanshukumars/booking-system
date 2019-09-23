package com.project.booking.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Vendor {

	@Id
	private String vendorId;
	private String vendorName;
	private String vendorUrl;
	
	@ManyToMany(mappedBy = "hotelVendors")
	private List<Hotel> hotels;

	public List<Hotel> getHotels() {
		return hotels;
	}

	public void setHotels(List<Hotel> hotels) {
		this.hotels = hotels;
	}

	public String getVendorId() {
		return vendorId;
	}

	public void setVendorId(String vendorId) {
		this.vendorId = vendorId;
	}

	public String getVendorName() {
		return vendorName;
	}

	public void setVendorName(String vendorName) {
		this.vendorName = vendorName;
	}

	public String getVendorUrl() {
		return vendorUrl;
	}

	public void setVendorUrl(String vendorUrl) {
		this.vendorUrl = vendorUrl;
	}

}
