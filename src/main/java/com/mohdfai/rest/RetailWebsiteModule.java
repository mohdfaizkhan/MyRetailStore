package com.mohdfai.rest;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import com.google.gson.Gson;
import com.mohdfai.entity.CustomerDetails;
import com.mohdfai.service.IRetailWebsiteService;

/**
 * @author mohdfai
 *
 */
@Path("/retailWebsite")
public class RetailWebsiteModule {

	@Inject
	IRetailWebsiteService retailService;

	@GET
	@Path("/custData/{customerId}")
	@Produces("application/json")
	public String loadCustomerDetails(@PathParam("customerId") String customerId) {

		CustomerDetails customerHolder = new CustomerDetails();
		Gson gson = new Gson();
		try {
			customerHolder = retailService.loadCustomerDetails(customerId);
			return gson.toJson(customerHolder);
		} catch (Exception exception) {
			customerHolder = new CustomerDetails();
			return gson.toJson(customerHolder);
		}

	}
	
	@POST
	@Path("registerUser")
	@Consumes("application/json")
	public String registerNewCustomer(String data)
	{
		Gson gson = new Gson();
		CustomerDetails customerHolder = gson.fromJson(data, CustomerDetails.class);
		try {
			String status = retailService.registerNewCustomer(customerHolder);
			return status;
		} catch (Exception exception) {
			customerHolder = new CustomerDetails();
			return "Failed";
		}
	}

}
