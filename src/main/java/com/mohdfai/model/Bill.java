package com.mohdfai.model;

public class Bill {
	private double groceriesAmount;
	private double nonGroceriesAmount;
	private double discount;
	private double payableAmount;

	public double getGroceriesAmount() {
		return groceriesAmount;
	}
	public void setGroceriesAmount(double groceriesAmount) {
		this.groceriesAmount = groceriesAmount;
	}
	public double getNonGroceriesAmount() {
		return nonGroceriesAmount;
	}
	public void setNonGroceriesAmount(double nonGroceriesAmount) {
		this.nonGroceriesAmount = nonGroceriesAmount;
	}
	public double getDiscount() {
		return discount;
	}
	public void setDiscount(double discount) {
		this.discount = discount;
	}
	public double getPayableAmount() {
		return payableAmount;
	}
	public void setPayableAmount(double payableAmount) {
		this.payableAmount = payableAmount;
	}

}
