package com.store.retail.responce;

import java.time.LocalDateTime;
import java.util.List;

public class InvoiceRPO {

	private long invoiceNo;
	private String customerName;
	private double totalDiscount; 
	private List<ItemRPO> items;
	private double totalAmount;
	private LocalDateTime dateAndTime;

	public InvoiceRPO(){
	}
	
	public InvoiceRPO(long invoiceNo, String customerName, double totalDiscountApplied, List<ItemRPO> items, double totalBill) {
		this.invoiceNo = invoiceNo;
		this.customerName = customerName;
		this.totalDiscount = totalDiscountApplied;
		this.items = items;
		this.totalAmount = totalBill;
		this.dateAndTime = LocalDateTime.now();
	}

	public long getInvoiceNo() {
		return invoiceNo;
	}

	public void setInvoiceNo(long invoiceNo) {
		this.invoiceNo = invoiceNo;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public double getTotalDiscount() {
		return totalDiscount;
	}

	public void setTotalDiscount(double totalDiscount) {
		this.totalDiscount = totalDiscount;
	}

	public List<ItemRPO> getItems() {
		return items;
	}

	public void setItems(List<ItemRPO> items) {
		this.items = items;
	}

	public double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}

	public LocalDateTime getDateAndTime() {
		return dateAndTime;
	}

	public void setDateAndTime() {
		this.dateAndTime = LocalDateTime.now();
	}
	
}
