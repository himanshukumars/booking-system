package com.project.booking.util;

import java.io.Serializable;

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

		try {
			String prefix = "ODID";
			Long recordCount = reservationRepository.count();
			return (prefix + recordCount);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}
}