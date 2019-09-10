package com.mohdfai.service;

import org.springframework.stereotype.Service;

import com.mohdfai.billing.BillingProcess;
import com.mohdfai.common.RetailConstants;
import com.mohdfai.common.UserType;
import com.mohdfai.model.Bill;
import com.mohdfai.model.User;

@Service
public class RetailService {
	
	private Bill bill;
	
	public Bill generateBill(User user) {
		BillingProcess billingProcess = new BillingProcess(); 	
		switch (user.getUserType()) {

		case EMPLOYEE:
			bill = billingProcess.generateBill(UserType.EMPLOYEE.getDiscountPercent(), RetailConstants.AMOUNT_BASEED_DISCOUNT_VALUE,user.getItemList());
			break;
			
		case AFFILIATED:
			bill = billingProcess.generateBill(UserType.AFFILIATED.getDiscountPercent(), RetailConstants.AMOUNT_BASEED_DISCOUNT_VALUE, user.getItemList());
			break;
		
		case VALUED_CUSTOMER:
			bill = billingProcess.generateBill(UserType.VALUED_CUSTOMER.getDiscountPercent(), RetailConstants.AMOUNT_BASEED_DISCOUNT_VALUE, user.getItemList());
			break;
		}
		
		return bill;
	}
	
	

}
