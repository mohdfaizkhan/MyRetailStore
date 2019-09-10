package com.mohdfai.dao;

import com.mohdfai.entity.CustomerDetails;

/**
 * @author mohdfai
 *
 */
public interface IRetailWebsiteDao {

	CustomerDetails loadCustomerDetails(String customerId);

	String registerNewCustomer(CustomerDetails customerHolder);
	
	
}
