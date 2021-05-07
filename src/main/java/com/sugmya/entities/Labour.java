package com.sugmya.entities;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.TableGenerator;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@TableGenerator(name = "startValue", initialValue = 101)
public class Labour {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY, generator = "startValue")
	private int id;
	
	private String name;
	private String aadharCard;
	private String category;
	private int salary;
	private String dutyArea;
	private String address;
	private String phone;
	
	@CreationTimestamp
	private Date createdAt;
	
	@UpdateTimestamp
	private Date modifiedAt;
	
	private int pendingSalary;
	private boolean isSalaryPaidInCurrentMonth = false;
	
	@OneToMany(cascade = CascadeType.REMOVE, mappedBy = "labour")
	private List<SalaryPaid> salaryPaids;
	
	@OneToMany(cascade = CascadeType.REMOVE, mappedBy = "labour")
	private List<ToolAllocated> toolAllocateds;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAadharCard() {
		return aadharCard;
	}
	public void setAadharCard(String aadharCard) {
		this.aadharCard = aadharCard;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Date getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	public Date getModifiedAt() {
		return modifiedAt;
	}
	public void setModifiedAt(Date modifiedAt) {
		this.modifiedAt = modifiedAt;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public int getPendingSalary() {
		return pendingSalary;
	}
	public void setPendingSalary(int pendingSalary) {
		this.pendingSalary = pendingSalary;
	}
	public boolean isSalaryPaidInCurrentMonth() {
		return isSalaryPaidInCurrentMonth;
	}
	public void setSalaryPaidInCurrentMonth(boolean isSalaryPaidInCurrentMonth) {
		this.isSalaryPaidInCurrentMonth = isSalaryPaidInCurrentMonth;
	}
	
	public List<SalaryPaid> getSalaryPaids() {
		return salaryPaids;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	public String getDutyArea() {
		return dutyArea;
	}
	public void setDutyArea(String dutyArea) {
		this.dutyArea = dutyArea;
	}
}
