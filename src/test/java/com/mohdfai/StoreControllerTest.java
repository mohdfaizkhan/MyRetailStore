package com.retail.store;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import com.retail.store.model.Bill;
import com.retail.store.service.RetailService;

@RunWith(SpringRunner.class)
@WebMvcTest
public class StoreControllerTest {
	
	@MockBean
	private RetailService retailService;
	
	@Autowired
	private MockMvc mockMvc;
	
	@Test
	public void testBillController() throws Exception {
		String content = "{\"userType\":\"EMPLOYEE\",\"itemList\":[{\"name\":\"Item1\",\"price\":200.0,\"itemType\":\"GROCERY\"},{\"name\":\"Item2\",\"price\":100.0,\"itemType\":\"GROCERY\"},{\"name\":\"Item3\",\"price\":200.0,\"itemType\":\"NON_GROCERY\"},{\"name\":\"Item4\",\"price\":500.0,\"itemType\":\"NON_GROCERY\"}]}";
		String expectedPayableAmount = "{payableAmount:755}";
		Bill bill = new Bill();
		bill.setDiscount(245);
		bill.setPayableAmount(755);
		bill.setGroceriesAmount(300);
		bill.setNonGroceriesAmount(700);
		
		Mockito.when(retailService.generateBill(Mockito.any())).thenReturn(bill);
		
		 MvcResult result = mockMvc.perform(post("/retail/bill")
				.content(content)
				.contentType(MediaType.APPLICATION_JSON))
		 		.andReturn();
		JSONAssert.assertEquals(expectedPayableAmount, result.getResponse().getContentAsString(), false);
		
	}
		


}
