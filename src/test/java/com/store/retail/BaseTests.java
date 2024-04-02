package com.store.retail;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.time.LocalDateTime;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import com.store.retail.constants.Industry;
import com.store.retail.constants.UserTypes;
import com.store.retail.modals.Item;
import com.store.retail.modals.UserDetail;
import com.store.retail.request.OrderItemsRQO;
import com.store.retail.request.OrderRequestRQO;
import com.store.retail.responce.InvoiceRPO;
import com.store.retail.services.DiscountCalculatorService;
import com.store.retail.services.InvoiceGeneratorService;
import com.store.retail.services.ItemService;
import com.store.retail.services.UserService;

/**
 * This class is used for Base Test class.
 * 
 * @author M Ahmed Shaikh
 *
 */
@ExtendWith(MockitoExtension.class)
@SpringBootTest
class BaseTests {

	@InjectMocks
	private InvoiceGeneratorService invoiceGenerator;

	@BeforeEach
	void setUp() {
		// Set up common behavior or mocks before each test method
	}

	@Test
	void shouldGenerateInvoiceEmployeeDiscount() {
		UserService userService = mock(UserService.class);
		UserDetail user = new UserDetail(1, "John", UserTypes.EMPLOYEE, LocalDateTime.now(), LocalDateTime.now());
		when(userService.getUserDetailById(1L)).thenReturn(user);

		ItemService itemService = mock(ItemService.class);
		Item item = new Item(1, "Item 1", "Item 1", 100.0, Industry.ELECTRONICS, true, LocalDateTime.now(),
				LocalDateTime.now());
		when(itemService.getItemById(1L)).thenReturn(item);

		DiscountCalculatorService discountCalculator = mock(DiscountCalculatorService.class);
		when(discountCalculator.calculateUserDiscountPercentage(UserTypes.EMPLOYEE, user.getCreatedDate()))
				.thenReturn(0.3);
		when(discountCalculator.calculateItemDiscount(item, 1, 0.3)).thenReturn(70.0);

		InvoiceGeneratorService invoiceGenerator = new InvoiceGeneratorService(discountCalculator, userService,
				itemService);
		OrderRequestRQO orderRequest = new OrderRequestRQO();
		orderRequest.setUserId(1L);
		orderRequest.setItems(List.of(new OrderItemsRQO(1L, 1, 1)));

		InvoiceRPO invoice = invoiceGenerator.generateInvoice(orderRequest);

		assertEquals(70.0, invoice.getTotalAmount());
	}

	@Test
	void shouldGenerateInvoiceAffiliateDiscount() {
		UserService userService = mock(UserService.class);
		UserDetail user = new UserDetail(1, "John", UserTypes.AFFILIATE, LocalDateTime.now(), LocalDateTime.now());
		when(userService.getUserDetailById(1L)).thenReturn(user);

		ItemService itemService = mock(ItemService.class);
		Item item = new Item(1, "Item 1", "Item 1", 50.0, Industry.ELECTRONICS, true, LocalDateTime.now(),
				LocalDateTime.now());
		when(itemService.getItemById(1L)).thenReturn(item);

		DiscountCalculatorService discountCalculator = mock(DiscountCalculatorService.class);
		when(discountCalculator.calculateUserDiscountPercentage(UserTypes.AFFILIATE, user.getCreatedDate()))
				.thenReturn(0.1);
		when(discountCalculator.calculateItemDiscount(item, 1, 0.1)).thenReturn(45.0);

		InvoiceGeneratorService invoiceGenerator = new InvoiceGeneratorService(discountCalculator, userService,
				itemService);
		OrderRequestRQO orderRequest = new OrderRequestRQO();
		orderRequest.setUserId(1L);
		orderRequest.setItems(List.of(new OrderItemsRQO(1L, 1, 1)));

		InvoiceRPO invoice = invoiceGenerator.generateInvoice(orderRequest);

		assertEquals(45.0, invoice.getTotalAmount());
	}

	@Test
	void shouldGenerateInvoiceCustomerDiscount() {
		UserService userService = mock(UserService.class);
		UserDetail user = new UserDetail(1, "John", UserTypes.CUSTOMER, LocalDateTime.now(), LocalDateTime.now());
		when(userService.getUserDetailById(1L)).thenReturn(user);

		ItemService itemService = mock(ItemService.class);
		Item item = new Item(1, "Item 1", "Item 1", 50.0, Industry.ELECTRONICS, true, LocalDateTime.now(),
				LocalDateTime.now());
		when(itemService.getItemById(1L)).thenReturn(item);

		DiscountCalculatorService discountCalculator = mock(DiscountCalculatorService.class);
		when(discountCalculator.calculateUserDiscountPercentage(UserTypes.CUSTOMER, user.getCreatedDate()))
				.thenReturn(0.05);
		when(discountCalculator.calculateItemDiscount(item, 1, 0.05)).thenReturn(47.5);

		InvoiceGeneratorService invoiceGenerator = new InvoiceGeneratorService(discountCalculator, userService,
				itemService);
		OrderRequestRQO orderRequest = new OrderRequestRQO();
		orderRequest.setUserId(1L);
		orderRequest.setItems(List.of(new OrderItemsRQO(1L, 1, 1)));

		InvoiceRPO invoice = invoiceGenerator.generateInvoice(orderRequest);

		assertEquals(47.5, invoice.getTotalAmount());
	}

	@Test
	void shouldGenerateInvoiceCustomerHundredDiscount() {
		LocalDateTime localDateTime = LocalDateTime.of(2018, 11, 22, 3, 15);
		UserService userService = mock(UserService.class);
		UserDetail user = new UserDetail(1, "John", UserTypes.CUSTOMER, LocalDateTime.now(), localDateTime);
		when(userService.getUserDetailById(1L)).thenReturn(user);

		ItemService itemService = mock(ItemService.class);
		Item item = new Item(1, "Item 1", "Item 1", 200.0, Industry.ELECTRONICS, true, LocalDateTime.now(),
				LocalDateTime.now());
		when(itemService.getItemById(1L)).thenReturn(item);

		DiscountCalculatorService discountCalculator = mock(DiscountCalculatorService.class);
		when(discountCalculator.calculateUserDiscountPercentage(UserTypes.CUSTOMER, user.getCreatedDate()))
				.thenReturn(0.05);
		when(discountCalculator.calculateItemDiscount(item, 1, 0.05)).thenReturn(180.0);

		InvoiceGeneratorService invoiceGenerator = new InvoiceGeneratorService(discountCalculator, userService,
				itemService);
		OrderRequestRQO orderRequest = new OrderRequestRQO();
		orderRequest.setUserId(1L);
		orderRequest.setItems(List.of(new OrderItemsRQO(1L, 1, 1)));

		InvoiceRPO invoice = invoiceGenerator.generateInvoice(orderRequest);

		assertEquals(180.0, invoice.getTotalAmount());
	}

	@Test
	void shouldGenerateInvoiceNoDiscount() {
		LocalDateTime localDateTime = LocalDateTime.of(2018, 11, 22, 3, 15);
		UserService userService = mock(UserService.class);
		UserDetail user = new UserDetail(1, "John", UserTypes.CUSTOMER, LocalDateTime.now(), localDateTime);
		when(userService.getUserDetailById(1L)).thenReturn(user);

		ItemService itemService = mock(ItemService.class);
		Item item = new Item(1, "Item 1", "Item 1", 100.0, Industry.GROCERY, true, LocalDateTime.now(),
				LocalDateTime.now());
		when(itemService.getItemById(1L)).thenReturn(item);

		DiscountCalculatorService discountCalculator = mock(DiscountCalculatorService.class);
		when(discountCalculator.calculateUserDiscountPercentage(UserTypes.CUSTOMER, user.getCreatedDate()))
				.thenReturn(0.05);
		when(discountCalculator.calculateItemDiscount(item, 1, 0.05)).thenReturn(100.0);

		InvoiceGeneratorService invoiceGenerator = new InvoiceGeneratorService(discountCalculator, userService,
				itemService);
		OrderRequestRQO orderRequest = new OrderRequestRQO();
		orderRequest.setUserId(1L);
		orderRequest.setItems(List.of(new OrderItemsRQO(1L, 1, 1)));

		InvoiceRPO invoice = invoiceGenerator.generateInvoice(orderRequest);

		assertEquals(100.0, invoice.getTotalAmount());
	}

}
