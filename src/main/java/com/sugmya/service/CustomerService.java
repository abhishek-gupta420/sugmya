package com.sugmya.service;

import java.util.List;

import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sugmya.dao.CustomerDao;
import com.sugmya.entities.Customer;

@Service
@Transactional
public class CustomerService {

	@Autowired
	private CustomerDao customerDao;
	
	public int createCustomer(Customer customer) {
		int id = 0;
		if(customer != null && customer.getArea() != null && !customer.getArea().equals(""))
		{
			customer.setUniqueId(generateUniqueId(customer.getArea()));
			id = customerDao.create(customer);
		}
		return id;
	}
	
	public void updateCustomer(Customer customer) {
		customerDao.update(customer);
	}
	
	public void deleteCustomer(Customer customer) {
		customerDao.delete(customer);
	}
	
	public Customer findById(int id) {
		if(id > 0)
			return customerDao.findOne(id);
		return null;
	}
	
	public List<Customer> findAll(){
		
		return customerDao.findAll();
	}
	
	public List<Customer> findByName(String name){
		return customerDao.findByName(name);
	}
	
	public Customer findByUniqueId(String uniqueId) {
		if(uniqueId != null) {
			return customerDao.findByUnique(uniqueId);
		}
		return null;
	}
	
	public Customer findByMobile(String mobile) {
		
		if(mobile != null) {
			return customerDao.findByMobile(mobile);
		}
		return null;
	}
	
	public List<Customer> findByArea(String area) {

		return customerDao.findByArea(area);
	}
	
	public long totalCustomer() {
		return customerDao.count();
	}
	
	public List<Customer> pendingBalCustomers(){
		return customerDao.pendingBalCustomers();
	}
	
	private String generateUniqueId(String area) {
		String uniqueId;
		int id = 10001;
	    id += customerDao.findLastId();
		if(area.length() <= 2)
			uniqueId = area.substring(0, 2);
		else
			uniqueId = area.substring(0, 3);
		uniqueId += String.valueOf(id).substring(1);
		return uniqueId.toUpperCase();
	}
	
}
