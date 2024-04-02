package com.store.retail.services;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.store.retail.constants.Industry;
import com.store.retail.modals.Item;
import com.store.retail.modals.UserDetail;
import com.store.retail.request.OrderItemsRQO;
import com.store.retail.request.OrderRequestRQO;
import com.store.retail.responce.InvoiceRPO;
import com.store.retail.responce.ItemRPO;

@Service
public class InvoiceGeneratorService {

	private final DiscountCalculatorService discountCalculator;
	private final UserService userService;
	private final ItemService itemService;

	public InvoiceGeneratorService(DiscountCalculatorService discountCalculator, UserService userService,
			ItemService itemService) {
		this.discountCalculator = discountCalculator;
		this.userService = userService;
		this.itemService = itemService;
	}

	public InvoiceRPO generateInvoice(OrderRequestRQO orderRequest) {
		UserDetail user = userService.getUserDetailById(orderRequest.getUserId());
		List<ItemRPO> items = new ArrayList<>();
		double userDiscountPercentage = discountCalculator.calculateUserDiscountPercentage(user.getUserType(),
				user.getCreatedDate());
		double totalDiscountApplied = 0.0d;
		double totalBill = 0.0d;
		double hunderDiscount = 0;

		totalDiscountApplied += totalBill * userDiscountPercentage;
		totalBill *= (1 - userDiscountPercentage);

		for (OrderItemsRQO orderItem : orderRequest.getItems()) {
			ItemRPO itemRPO = new ItemRPO();
			Item item = itemService.getItemById(orderItem.getItemId());
			if (item.getIndustry() != Industry.GROCERY) {
				hunderDiscount += item.getPrice();
			}
			items.add(itemRPO.from(item, orderItem.getQuantity()));
			totalBill += discountCalculator.calculateItemDiscount(item, orderItem.getQuantity(),
					userDiscountPercentage);
			totalDiscountApplied += discountCalculator.calculateDiscountOnItemPrice(item, orderItem.getQuantity(),
					userDiscountPercentage);
		}

		double additionalDiscount = discountCalculator.calculateAdditionalDiscount(hunderDiscount);
		totalBill -= additionalDiscount;
		totalDiscountApplied += additionalDiscount;

		return new InvoiceRPO(12, user.getUserName(), totalDiscountApplied, items, totalBill, LocalDateTime.now());
	}
}