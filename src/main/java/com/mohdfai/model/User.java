package com.mohdfai.model;

import java.util.List;

import com.mohdfai.common.UserType;

public class User {
	private UserType userType;
	private List<Item> itemList;

	public UserType getUserType() {
		return userType;
	}
	public void setUserType(UserType userType) {
		this.userType = userType;
	}
	public List<Item> getItemList() {
		return itemList;
	}
	public void setItemList(List<Item> itemList) {
		this.itemList = itemList;
	}

}