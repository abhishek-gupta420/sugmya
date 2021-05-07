package com.sugmya.service;

import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sugmya.dao.CompanyDao;
import com.sugmya.entities.Company;

@Service
@Transactional
public class CompanyService {

	@Autowired
	private CompanyDao companyDao;
	
	public Company login(String username, String password) {
		
		if(username != null && password != null) {
			
			Company company = companyDao.login(username, password);
			
			if(company != null && username.equals(company.getUsername()) && password.equals(company.getPassword()))
				return company;
		}
		return null;
	}
	
	public boolean save(Company company) {
		
		if(companyDao.create(company)==1)
			return true;
		return false;
	}
	
	public boolean update(Company company) {
		
		
		if(!company.getName().equals("")) {
			companyDao.update(company);
			return true;
		}
		return false;
		
	}
	
	public Company findById(int id) {
		if(id > 0)
			return companyDao.findOne(id);
		return null;
	}
	
	public List<Company> findAll(){
		
		return companyDao.findAll();
	}
	
	public boolean changePassword(String oldPassword, String newPassword) {
		
		Company company = findById(1);
		if(company != null) {
			if(oldPassword.equals(company.getPassword())) {
				company.setPassword(newPassword);
				update(company);
				return true;
			}
		}
		return false;
	}
	
	public boolean changeUsername(String username, String password) {
		
		Company company = findById(1);
		if(company != null) {
			if(password.equals(company.getPassword())) {
				company.setUsername(username);
				update(company);
				return true;
			}
		}
		return false;
	}
}
