package com.sugmya.dao;

import org.springframework.stereotype.Repository;

import com.sugmya.entities.SalaryPaid;

@Repository
public class SalaryPaidDao extends AbstractHibernateDao<SalaryPaid>{

	public SalaryPaidDao() {
		setClazz(SalaryPaid.class);
	}
}
