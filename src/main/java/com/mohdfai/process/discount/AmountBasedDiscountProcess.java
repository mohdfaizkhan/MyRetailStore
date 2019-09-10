package com.mohdfai.process.discount;

public class AmountBasedDiscountProcess implements DiscountProcess{
	private double discountValue;
	
	public AmountBasedDiscountProcess(double discountValue) {
		this.discountValue = discountValue;
	}
	
	public double applyDiscount(double amount) {
		
		return (int) (amount / 100) * discountValue;
	}

}
