package com.sugmya.dao;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;
import com.sugmya.entities.Labour;

@Repository
public class LabourDao extends AbstractHibernateDao<Labour>{

	private Query query;
	public LabourDao() {
		setClazz(Labour.class);
	}
	
	@SuppressWarnings("unchecked")
	public List<Labour> findByName(String name) {
		
		query = getCurrentSession().createQuery("FROM Labour l where l.name = :name");
		query.setString("name", name);
		return query.list();
	}
	
	@SuppressWarnings("unchecked")
	public Labour findByMobile(String mobile) {
		query = getCurrentSession().createQuery("FROM Customer c where c.phoneNumber = :mobile");
		query.setString("mobile", mobile);
		List<Labour> labours  = query.list();
		if(!labours.isEmpty()) {
			labours.get(0);
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	public List<Labour> pendingBalLabours() {
		
		query = getCurrentSession().createQuery("FROM Labour l where l.pendingSalary > 0");
		return query.list();
	}
}
