package com.store.retail.request;


public class OrderItemsRQO {

	private long id;
	private long itemId;
	private int quantity;
	
	public OrderItemsRQO(long id, long itemId, int quantity) {
		this.id = id;
		this.itemId = itemId;
		this.quantity = quantity;
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public long getItemId() {
		return itemId;
	}
	public void setItemId(long itemId) {
		this.itemId = itemId;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
}
