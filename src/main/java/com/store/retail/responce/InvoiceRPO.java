package com.store.retail.responce;

import java.time.LocalDateTime;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class InvoiceRPO {

	private long invoiceNo;
	private String customerName;
	private double totalDiscount;
	private List<ItemRPO> items;
	private double totalAmount;
	private LocalDateTime dateAndTime;

}
