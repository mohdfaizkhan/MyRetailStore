package com.mohdfai.serviceimpl;

import javax.inject.Inject;
import javax.inject.Named;
import javax.transaction.Transactional;

import com.mohdfai.dao.IRetailWebsiteDao;
import com.mohdfai.dto.CustomerHolder;
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
	public String registerNewCustomer(CustomerHolder customerHolder) {

		return retailDao.registerNewCustomer(customerHolder);

	}

	@Override
	@Transactional
	public CustomerHolder loadCustomerDetails(String customerId) {

		CustomerHolder customerHolder = new CustomerHolder();

		CustomerDetails customer = retailDao.loadCustomerDetails(customerId);

		if (null != customer) {

			customerHolder.setCustomerId(String.valueOf(customer.getCustomerId()));
			customerHolder.setCustomerName(customer.getCustomerName());
			customerHolder.setGender(customer.getGender());
			customerHolder.setAddress(customer.getAddress());
			customerHolder.setEmail(customer.getEmail());
			customerHolder.setTelephone(customer.getTelephone());
			customerHolder.setCustomerType(customer.getCustomerType());
			customerHolder.setCreatedDate(customer.getCreatedDate());

		}

		return customerHolder;
	}

}
