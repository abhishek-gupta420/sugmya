package com.sugmya.service;

import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sugmya.dao.ToolAllocatedDao;
import com.sugmya.entities.Labour;
import com.sugmya.entities.ToolAllocated;

@Service
@Transactional
public class ToolAllocatedService {

	@Autowired
	private ToolAllocatedDao toolAllocatedDao;
	
	public int createToolAllocated(ToolAllocated toolAllocated) {
		return toolAllocatedDao.create(toolAllocated);
	}
	
	public void updateToolAllocated(ToolAllocated toolAllocated) {
		toolAllocatedDao.update(toolAllocated);
	}
	
	public void deleteToolAllocated(int id) {
		if(id != 0) {
			ToolAllocated toolAllocated =  findById(id);
			toolAllocatedDao.delete(toolAllocated);
		}
		
	}
	
	public ToolAllocated findById(int id) {
		if(id > 0)
			return toolAllocatedDao.findOne(id);
		return null;
	}
	
	public List<ToolAllocated> findAll(){
		
		return toolAllocatedDao.findAll();
	}
	
	public long totalToolAllocated() {
		return toolAllocatedDao.count();
	}
	
	public List<ToolAllocated> findByLabour(Labour labour){
		return toolAllocatedDao.getToolByLabour(labour);
		
	}
}
