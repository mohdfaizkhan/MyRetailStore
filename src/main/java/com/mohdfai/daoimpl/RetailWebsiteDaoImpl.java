package com.mohdfai.daoimpl;

import javax.inject.Named;
import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import com.mohdfai.dao.IRetailWebsiteDao;
import com.mohdfai.entity.CustomerDetails;
import com.mohdfai.retailwebsite.util.HibernateUtil;

/**
 * @author mohdfai
 *
 */
@Named
public class RetailWebsiteDaoImpl implements IRetailWebsiteDao {

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.mohdfai.dao.IRetailWebsiteDao#registerNewCustomer(com.mohdfai.dto.
	 * CustomerHolder)
	 */
	@Override
	@Transactional
	public String registerNewCustomer(CustomerDetails customerHolder) {
		
		try (Session session = HibernateUtil.getSessionFactory().openSession())
		{
				session.save(customerHolder);
				return "Success";
		} catch (HibernateException exception) {
			throw exception;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.mohdfai.dao.IRetailWebsiteDao#loadCustomerDetails(java.lang.String)
	 */
	@Override
	@Transactional
	public CustomerDetails loadCustomerDetails(String customerId) {

		CustomerDetails customer = CustomerDetails.builder().build();
		try (Session session = HibernateUtil.getSessionFactory().openSession())
		{
				Criteria criteria = session.createCriteria(CustomerDetails.class);
				criteria.add(Restrictions.eq("customerId",Integer.parseInt(customerId)));
				customer = (CustomerDetails) criteria.uniqueResult();
			
		} catch (Exception exception) {
			throw exception;
		}
		return customer;
	}

}
