package com.retail.store;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.retail.store.common.ItemType;
import com.retail.store.common.UserType;
import com.retail.store.model.Bill;
import com.retail.store.model.Item;
import com.retail.store.model.User;
import com.retail.store.service.RetailService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class StoreServiceTest {
	
	@Autowired
	private RetailService LandinLandingManagedBean;
	
	@Test
	public void testRetailServiceEmployee() {
		Bill bill = retailService.generateBill(getUser(UserType.EMPLOYEE));
		System.out.println("Bill"+ bill.getPayableAmount());
		Assert.assertEquals(755.0d, bill.getPayableAmount(),0.0);
	}
	
	
	@Test
	public void testRetailServiceAffiliated() {
		Bill bill = retailService.generateBill(getUser(UserType.AFFILIATED));
		Assert.assertEquals(885.0d, bill.getPayableAmount(),0.0);
		
	}
	
	@Test
	public void testRetailServiceValuedCustomer() {
		Bill bill = retailService.generateBill(getUser(UserType.VALUED_CUSTOMER));
		Assert.assertEquals(920.0d, bill.getPayableAmount(),0.0);
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
