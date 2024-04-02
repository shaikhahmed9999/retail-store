package com.store.retail.responce;

import com.store.retail.modals.Item;


public class ItemRPO {
	
 private String itemName;
 private int quantity;
 private double price;
 
public String getItemName() {
	return itemName;
}
public void setItemName(String itemName) {
	this.itemName = itemName;
}
public int getQuantity() {
	return quantity;
}
public void setQuantity(int quantity) {
	this.quantity = quantity;
}
public double getPrice() {
	return price;
}
public void setPrice(double price) {
	this.price = price;
}
 
public ItemRPO from(Item item, int quantity) {
	this.itemName = item.getItemName();
	this.quantity = quantity;
	this.price = item.getPrice();
	return this;
}

}
