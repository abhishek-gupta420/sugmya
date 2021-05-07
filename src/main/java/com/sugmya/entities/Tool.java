package com.sugmya.entities;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PreUpdate;
import org.hibernate.annotations.CreationTimestamp;

@Entity
public class Tool {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String toolName;
	private int allocated;
	private int available;
	private int totalQuantity;
	
	@OneToMany(cascade = CascadeType.REMOVE, mappedBy = "tool")
	private List<ToolAllocated> toolsAllocated;
	
	@CreationTimestamp
	private Date createdAt;
	
	@PreUpdate
	private void onUpdate() {
		totalQuantity = allocated + available;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getToolName() {
		return toolName;
	}

	public void setToolName(String toolName) {
		this.toolName = toolName;
	}

	public int getAllocated() {
		return allocated;
	}

	public void setAllocated(int allocated) {
		this.allocated = allocated;
	}

	public int getAvailable() {
		return available;
	}

	public void setAvailable(int available) {
		this.available = available;
	}

	public int getTotalQuantity() {
		return totalQuantity;
	}

	public void setTotalQuantity(int totalQuantity) {
		this.totalQuantity = totalQuantity;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public List<ToolAllocated> getToolsAllocated() {
		return toolsAllocated;
	}

	public void setToolsAllocated(List<ToolAllocated> toolsAllocated) {
		this.toolsAllocated = toolsAllocated;
	}
}
