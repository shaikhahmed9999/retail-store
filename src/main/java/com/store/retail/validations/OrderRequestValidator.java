package com.store.retail.validations;

import com.store.retail.exceptions.DuplicateItemException;
import com.store.retail.request.OrderItemsRQO;
import com.store.retail.request.OrderRequestRQO;

import java.util.HashSet;
import java.util.Set;

public class OrderRequestValidator {

	private OrderRequestValidator() {
		throw new AssertionError();
	}

	public static void validateOrderRequest(OrderRequestRQO orderRequest) {
		Set<Long> itemIds = new HashSet<>();
		for (OrderItemsRQO item : orderRequest.getItems()) {
			if (!itemIds.add(item.getItemId())) {
				throw new DuplicateItemException("Duplicate itemId found: " + item.getItemId());
			}
		}
	}
}