package com.sugmya.dao;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.sugmya.entities.Labour;
import com.sugmya.entities.ToolAllocated;

@Repository
public class ToolAllocatedDao extends AbstractHibernateDao<ToolAllocated>{
	
	private Query query;
	
	public ToolAllocatedDao() {
		setClazz(ToolAllocated.class);
	}
	
	@SuppressWarnings("unchecked")
	public List<ToolAllocated> getToolByLabour(Labour labour){
		query = getCurrentSession().createQuery("From ToolAllocated t where t.labour = :labour");
		query.setParameter("labour", labour);
		return query.list();
	}
}
