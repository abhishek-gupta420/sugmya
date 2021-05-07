package com.sugmya.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sugmya.dao.ToolDao;
import com.sugmya.entities.Tool;

@Service
@Transactional
public class ToolService {

	@Autowired
	private ToolDao toolDao;
	
	public void createTool(Tool tool) {
		toolDao.create(tool);
	}
	
	public void updateTool(Tool tool) {
		toolDao.update(tool);
	}
	
	public void deleteTool(Tool tool) {
		toolDao.delete(tool);
	}
	
	public Tool findById(int id) {
		if(id > 0)
			return toolDao.findOne(id);
		return null;
	}
	
	public List<Tool> findAll(){
		
		return toolDao.findAll();
	}
	
	public List<Tool> findByName(String toolName){
		return toolDao.findByName(toolName);
	}
	
	public long totalItem() {
		return toolDao.count();
	}
}
