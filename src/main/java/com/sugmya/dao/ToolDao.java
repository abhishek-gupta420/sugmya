package com.sugmya.dao;

import java.util.List;
import javax.transaction.Transactional;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;
import com.sugmya.entities.Tool;

@Repository
@Transactional
public class ToolDao extends AbstractHibernateDao<Tool>{

	private Query query;
	public ToolDao() {
		setClazz(Tool.class);
	}
	
	@SuppressWarnings("unchecked")
	public List<Tool> findByName(String toolName) {
		
		query = getCurrentSession().createQuery("FROM Tool l where l.toolName = :toolName");
		query.setString("name", toolName);
		return query.list();
	}

}
