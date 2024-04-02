package com.store.retail.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.store.retail.request.OrderRequestRQO;
import com.store.retail.responce.InvoiceRPO;
import com.store.retail.services.InvoiceGeneratorService;
import com.store.retail.validations.OrderRequestValidator;

@RestController
@RequestMapping("/checkout")
public class BillingController {

	private InvoiceGeneratorService invoiceGenerator;

	public BillingController(InvoiceGeneratorService invoiceGenerator) {
		this.invoiceGenerator = invoiceGenerator;
	}

	@GetMapping("/bill")
	public InvoiceRPO getBilling(@RequestBody OrderRequestRQO orderRequest) {
		OrderRequestValidator.validateOrderRequest(orderRequest);
		return invoiceGenerator.generateInvoice(orderRequest);
	}

}
