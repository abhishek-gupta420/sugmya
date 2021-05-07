package com.sugmya.dao;

import org.springframework.stereotype.Repository;

import com.sugmya.entities.RentPaid;

@Repository
public class RentPaidDao extends AbstractHibernateDao<RentPaid>{

	public RentPaidDao() {
		setClazz(RentPaid.class);
	}
}
