package com.sugmya.dao;

import java.util.List;
import javax.transaction.Transactional;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.sugmya.entities.Customer;

@Repository
@Transactional
public class CustomerDao extends AbstractHibernateDao<Customer>{

	private Query query;
	
	public CustomerDao() {
		setClazz(Customer.class);
	}
	
	@SuppressWarnings("unchecked")
	public List<Customer> findByName(String name) {
		
		query = getCurrentSession().createQuery("FROM Customer c where c.name = :name");
		query.setString("name", name);
		return query.list();
	}
	
	public int  findLastId() {
		query = getCurrentSession().createQuery("FROM Customer c order by c.id DESC");
		query.setMaxResults(1);
		Customer customer = (Customer) query.uniqueResult();
		if (customer != null) {
			return customer.getId();
		}
		return 0;
	}
	
	public Customer findByUnique(String uniqueId) {
		
		query = getCurrentSession().createQuery("FROM Customer c where c.uniqueId = :uniqueId");
		query.setString("uniqueId", uniqueId);
		return (Customer) query.uniqueResult();
	}
	
	public Customer findByMobile(String mobile) {
		query = getCurrentSession().createQuery("FROM Customer c where c.phoneNumber = :mobile");
		query.setString("mobile", mobile);
		return (Customer) query.uniqueResult();
	}
	
	@SuppressWarnings("unchecked")
	public List<Customer> findByArea(String area) {
		query = getCurrentSession().createQuery("FROM Customer c where c.area = :area");
		query.setString("area", area);
		return query.list();
	}
	
	@SuppressWarnings("unchecked")
	public List<Customer> pendingBalCustomers() {
		query = getCurrentSession().createQuery("FROM Customer c where c.totalBal > 0");
		return query.list();
	}
}