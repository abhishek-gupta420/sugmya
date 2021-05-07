package com.sugmya.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sugmya.dao.SalaryPaidDao;
import com.sugmya.entities.SalaryPaid;

@Service
@Transactional
public class SalaryPaidService {

	@Autowired
	private SalaryPaidDao salaryPaidDao;
	
	public int createSalaryPaid(SalaryPaid salaryPaid) {
		return salaryPaidDao.create(salaryPaid);
	}
	
	public void updateSalaryPaid(SalaryPaid salaryPaid) {
		salaryPaidDao.update(salaryPaid);
	}
	
	public void deleteSalaryPaid(int id) {
		if(id != 0) {
			SalaryPaid salaryPaid =  findById(id);
			salaryPaidDao.delete(salaryPaid);
		}
		
	}
	
	public SalaryPaid findById(int id) {
		if(id > 0)
			return salaryPaidDao.findOne(id);
		return null;
	}
	
	public List<SalaryPaid> findAll(){
		
		return salaryPaidDao.findAll();
	}
}
