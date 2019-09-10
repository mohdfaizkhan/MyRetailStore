package com.mohdfai.serviceimpl;

import java.util.Optional;

import javax.inject.Inject;
import javax.inject.Named;
import javax.transaction.Transactional;

import com.mohdfai.dao.IRetailWebsiteDao;
import com.mohdfai.entity.CustomerDetails;
import com.mohdfai.service.IRetailWebsiteService;

/**
 * @author mohdfai
 *
 */

@Named
public class RetailWebsiteServiceImpl implements IRetailWebsiteService {

	@Inject
	IRetailWebsiteDao retailDao;

	@Override
	@Transactional
	public String registerNewCustomer(CustomerDetails customerHolder) 
	{
		return retailDao.registerNewCustomer(customerHolder);
	}

	@Override
	public CustomerDetails loadCustomerDetails(String customerId)
	{
		return Optional.of(retailDao.loadCustomerDetails(customerId))
		.map(customer->customer)
		.orElse(CustomerDetails.builder().build());

	}

}
