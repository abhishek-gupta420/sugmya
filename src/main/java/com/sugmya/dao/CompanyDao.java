package com.sugmya.dao;

import javax.transaction.Transactional;
import org.springframework.stereotype.Repository;
import com.sugmya.entities.Company;

@Repository
@Transactional
public class CompanyDao extends AbstractHibernateDao<Company>{

	private org.hibernate.Query query;
	public CompanyDao() {
		setClazz(Company.class);
	}
	
	public Company login(String username, String password) {
		
		query = getCurrentSession().createQuery("FROM Company a where a.username = :username and a.password = :password");
		query.setParameter("username", username);
		query.setParameter("password", password);
		Company company = (Company) query.uniqueResult();
		return company;
	}
}
