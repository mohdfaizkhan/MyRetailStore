package com.mohdfai.common;

public enum UserType {
	EMPLOYEE(30),
	AFFILIATED(10),
	VALUED_CUSTOMER(5);

	private double discountPercent;

	private UserType(double discountPercent) {
		this.discountPercent = discountPercent;
	}
	
	public double getDiscountPercent() {
		return discountPercent;
	}
}
