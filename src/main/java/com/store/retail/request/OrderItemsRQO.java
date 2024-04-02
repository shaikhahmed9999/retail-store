package com.store.retail.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class OrderItemsRQO {

	private long id;
	private long itemId;
	private int quantity;

}
