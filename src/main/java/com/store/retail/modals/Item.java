package com.store.retail.modals;

import java.time.LocalDateTime;

import com.store.retail.constants.Industry;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Item {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Column(unique = true) 
	private String itemName;
	private String description;
	private double price;
	private Industry industry;
	private boolean status;
	private LocalDateTime createdDate;
	private LocalDateTime modifiedDate;
	
	public Item() {
		}
	
	public Item(String itemName, String description, double price, Industry industry, boolean status,
			LocalDateTime createdDate, LocalDateTime modifiedDate) {
		this.itemName = itemName;
		this.description = description;
		this.price = price;
		this.industry = industry;
		this.status = status;
		this.createdDate = createdDate;
		this.modifiedDate = modifiedDate;
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public Industry getIndustry() {
		return industry;
	}
	public void setIndustry(Industry industry) {
		this.industry = industry;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public LocalDateTime getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(LocalDateTime createdDate) {
		this.createdDate = createdDate;
	}
	public LocalDateTime getModifiedDate() {
		return modifiedDate;
	}
	public void setModifiedDate(LocalDateTime modifiedDate) {
		this.modifiedDate = modifiedDate;
	}
	
	
}
