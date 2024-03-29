package com.project.booking.util;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;
import org.springframework.beans.factory.annotation.Autowired;

import com.project.booking.dao.ReservationRepository;

public class ReservationIdGenerator implements IdentifierGenerator {

	@Autowired
	ReservationRepository reservationRepository;

	@Override
	public Serializable generate(SharedSessionContractImplementor session, Object object) throws HibernateException {

		Connection connection = session.connection();		
		try {
			Statement statement=connection.createStatement();
			ResultSet rs=statement.executeQuery("select count(reservation_id) as Id from reservation");

			String prefix = "ODHOT";
			if(rs.next()) {
				Integer rsCount=rs.getInt(1)+10;
				return (prefix + rsCount.toString());
	             
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}
}