package com.mohdfai.dao;

import com.mohdfai.dto.CustomerHolder;
import com.mohdfai.entity.CustomerDetails;

/**
 * @author mohdfai
 *
 */
public interface IRetailWebsiteDao {

	String registerNewCustomer(CustomerHolder customerHolder);
	
	CustomerDetails loadCustomerDetails(String customerId);
	
	
}
