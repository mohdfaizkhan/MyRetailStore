package com.mohdfai.service;

import com.mohdfai.dto.CustomerHolder;

/**
 * @author mohdfai
 *
 */
public interface IRetailWebsiteService {
	
    String registerNewCustomer(CustomerHolder customerHolder);
	
	CustomerHolder loadCustomerDetails(String customerId); 

}
