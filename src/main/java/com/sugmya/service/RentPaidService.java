package com.sugmya.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sugmya.dao.RentPaidDao;
import com.sugmya.entities.RentPaid;

@Service
@Transactional
public class RentPaidService {

	@Autowired
	private RentPaidDao rentPaidDao;
	
	public int createRentPaid(RentPaid rentPaid) {
		return rentPaidDao.create(rentPaid);
	}
	
	public void updateRentPaid(RentPaid rentPaid) {
		rentPaidDao.update(rentPaid);
	}
	
	public void deleteRentPaid(int id) {
		if(id != 0) {
			RentPaid rentPaid =  findById(id);
			rentPaidDao.delete(rentPaid);
		}
		
	}
	
	public RentPaid findById(int id) {
		if(id > 0)
			return rentPaidDao.findOne(id);
		return null;
	}
	
	public List<RentPaid> findAll(){
		
		return rentPaidDao.findAll();
	}
}
