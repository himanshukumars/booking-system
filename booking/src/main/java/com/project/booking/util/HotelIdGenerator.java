package com.project.booking.util;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;
import org.springframework.beans.factory.annotation.Autowired;

import com.project.booking.dao.HotelRepository;

public class HotelIdGenerator implements IdentifierGenerator {

	@Autowired
	HotelRepository hotelRepository;

	@Override
	public Serializable generate(SharedSessionContractImplementor session, Object object) throws HibernateException {

		Connection connection = session.connection();		
		try {
			Statement statement=connection.createStatement();
			ResultSet rs=statement.executeQuery("select count(hotel_id) as Id from hotel");

			String prefix = "HOTL";
			if(rs.next()) {
				Integer hotelCount=rs.getInt(1)+101;
				return (prefix + hotelCount.toString());
	             
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
}
