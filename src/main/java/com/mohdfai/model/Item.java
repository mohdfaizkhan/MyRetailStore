package com.mohdfai.model;

import com.mohdfai.common.ItemType;

public class Item {
	private String name;
	private double price;
	private ItemType itemType;

	
	public Item() {
	}
	public Item(String name, double price, ItemType itemType) {
		super();
		this.name = name;
		this.price = price;
		this.itemType = itemType;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public ItemType getItemType() {
		return itemType;
	}
	public void setItemType(ItemType itemType) {
		this.itemType = itemType;
	}
	
}
