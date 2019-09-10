package com.mohdfai.retail;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.mohdfai.common.ItemType;
import com.mohdfai.common.UserType;
import com.mohdfai.model.Bill;
import com.mohdfai.model.Item;
import com.mohdfai.model.User;
import com.mohdfai.service.RetailService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class StoreServiceTest {
	
	@Autowired
	private RetailService retailService;
	
	@Test
	public void testRetailServiceEmployee() {
		
		Bill bill = retailService.generateBill(getUser(UserType.EMPLOYEE));
		System.out.println("Bill"+ bill.getPayableAmount());
		assertEquals(755.0d, bill.getPayableAmount(),0.0);
	}
	
	
	@Test
	public void testRetailServiceAffiliated() {
		Bill bill = retailService.generateBill(getUser(UserType.AFFILIATED));
		assertEquals(885.0d, bill.getPayableAmount(),0.0);
		
	}
	
	@Test
	public void testRetailServiceValuedCustomer() {
		Bill bill = retailService.generateBill(getUser(UserType.VALUED_CUSTOMER));
		assertEquals(920.0d, bill.getPayableAmount(),0.0);
	}
	
	private User getUser(UserType userType) {
		User user = new User();
		user.setUserType(userType);
		List<Item> itemList = new ArrayList<>();
 		itemList.add(new Item("Item1", 200.0, ItemType.GROCERY));
 		itemList.add(new Item("Item2", 100.0, ItemType.GROCERY));
 		itemList.add(new Item("Item3", 200.0, ItemType.NON_GROCERY));
 		itemList.add(new Item("Item4", 500.0, ItemType.NON_GROCERY));
		user.setItemList(itemList);
		return user;
	}
	
	
	

}
