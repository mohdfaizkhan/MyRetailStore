package com.mohdfai.service;

import com.mohdfai.entity.CustomerDetails;

/**
 * @author mohdfai
 *
 */
public interface IRetailWebsiteService {
	
    String registerNewCustomer(CustomerDetails customerHolder);
	
    CustomerDetails loadCustomerDetails(String customerId); 

}
