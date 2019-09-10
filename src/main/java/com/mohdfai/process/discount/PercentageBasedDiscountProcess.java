package com.mohdfai.process.discount;

public class PercentageBasedDiscountProcess implements DiscountProcess{
	private double discountPercent;

	public PercentageBasedDiscountProcess(double discountPercent) {
		this.discountPercent = discountPercent;
		
	}
	
	public double applyDiscount(double amount) {
		return (discountPercent * amount)/100;
	}

}
