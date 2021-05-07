package com.sugmya.entities;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String uniqueId;
	private String name;
	
	@CreationTimestamp
	private Date createdAt;
	
	@UpdateTimestamp
	private Date modifiedAt;
	private String address;
	private String phoneNumber;
	private String aadharCard;
	private String email;
	private int rent;
	private String area;
	private int currentBal;
	private int pendingBal;
	private int totalBal;
	
	@OneToMany(cascade = CascadeType.REMOVE, mappedBy = "customer")
	private List<RentPaid> rentPaid;
	
	@PrePersist
	private void onCreate() {
		Calendar calendar = Calendar.getInstance();
		int rentPerDay = rent / calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
		totalBal = currentBal = rentPerDay * (calendar.getActualMaximum(Calendar.DAY_OF_MONTH) - calendar.get(Calendar.DAY_OF_MONTH));
		
	}
	
	@PreUpdate
	private void onUpdate() {
		totalBal = currentBal + pendingBal;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUniqueId() {
		return uniqueId;
	}
	public void setUniqueId(String uniqueId) {
		this.uniqueId = uniqueId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getAadharCard() {
		return aadharCard;
	}
	public void setAadharCard(String aadharCard) {
		this.aadharCard = aadharCard;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getRent() {
		return rent;
	}
	public void setRent(int rent) {
		this.rent = rent;
	}
	public int getCurrentBal() {
		return currentBal;
	}
	public void setCurrentBal(int currentBal) {
		this.currentBal = currentBal;
	}
	public int getPendingBal() {
		return pendingBal;
	}
	public void setPendingBal(int pendingBal) {
		this.pendingBal = pendingBal;
	}
	public int getTotalBal() {
		return totalBal;
	}
	public void setTotalBal(int totalBal) {
		this.totalBal = totalBal;
	}
}
