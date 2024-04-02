package com.store.retail.request;

import java.util.List;

public class OrderRequestRQO {

	private long userId;
	List<OrderItemsRQO> items;
	
	public long getUserId() {
		return userId;
	}
	public void setUserId(long userId) {
		this.userId = userId;
	}
	public List<OrderItemsRQO> getItems() {
		return items;
	}
	public void setItems(List<OrderItemsRQO> items) {
		this.items = items;
	}
	
}
