package com.store.retail.responce;

import com.store.retail.modals.Item;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ItemRPO {

	private String itemName;
	private int quantity;
	private double price;

	public ItemRPO from(Item item, int quantity) {
		this.itemName = item.getItemName();
		this.quantity = quantity;
		this.price = item.getPrice();
		return this;
	}

}
