package com.store.retail.services;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

import org.springframework.stereotype.Service;

import com.store.retail.constants.Discounts;
import com.store.retail.constants.Industry;
import com.store.retail.constants.UserTypes;
import com.store.retail.modals.Item;

@Service
public class DiscountCalculator {

    public double calculateUserDiscountPercentage(UserTypes userType, LocalDateTime userSince) {
        double userDiscountPercentage = 0.0d;
        switch (userType) {
            case AFFILIATE:
                userDiscountPercentage = Discounts.AFFILIATE.getDiscount();
                break;
            case CUSTOMER:
                if (ChronoUnit.YEARS.between(userSince, LocalDateTime.now()) > 2) {
                    userDiscountPercentage = Discounts.CUSTOMER.getDiscount();
                }
                break;
            case EMPLOYEE:
                userDiscountPercentage = Discounts.EMPLOYEE.getDiscount();
                break;
        }
        return userDiscountPercentage;
    }

    public double calculateAdditionalDiscount(double totalBill) {
    	 return Math.floor(totalBill / 100) * 5; 
    }

    public double calculateItemDiscount(Item item, int quantity, double userDiscountPercentage) {
    	return quantity * item.getPrice() - calculateDiscountOnItemPrice(item, quantity,userDiscountPercentage);
    }
    
    public double calculateDiscountOnItemPrice(Item item, int quantity, double userDiscountPercentage) {
    	return quantity * item.getPrice() * ((item.getIndustry().equals(Industry.GROCERY)) ? 0 : userDiscountPercentage);
    }
}