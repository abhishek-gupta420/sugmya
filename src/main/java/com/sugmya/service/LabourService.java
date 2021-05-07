package com.sugmya.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sugmya.dao.LabourDao;
import com.sugmya.entities.Labour;

@Service
@Transactional
public class LabourService {

	@Autowired
	private LabourDao labourDao;
	
	public int createLabour(Labour labour) {
		return labourDao.create(labour);
	}
	
	public void updateLabour(Labour labour) {
		labourDao.update(labour);
	}
	
	public void deleteLabour(int id) {
		if(id != 0) {
			Labour labour =  findById(id);
			labourDao.delete(labour);
		}
		
	}
	
	public Labour findById(int id) {
		if(id > 0)
			return labourDao.findOne(id);
		return null;
	}
	
	public List<Labour> findAll(){
		
		return labourDao.findAll();
	}
	
	public List<Labour> findByName(String name){
		return labourDao.findByName(name);
	}
	
	public Labour findByMobile(String mobile) {
		
		if(mobile != null) {
			return labourDao.findByMobile(mobile);
		}
		return null;
	}
	
	public long totalLabour() {
		return labourDao.count();
	}

	public List<Labour> pendingBalLabours() {
		return labourDao.pendingBalLabours();
	}
}
