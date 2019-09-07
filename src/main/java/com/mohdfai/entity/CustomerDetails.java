package com.mohdfai.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author mohdfai
 *
 */
@Entity
@Table(name="customer_details")
public class CustomerDetails {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "customer_id")
	private int customerId;
	
	@Column(name="customer_name") 
	private String customerName;
	
	@Column
	private String gender;
	
	@Column
	private String address;

	@Column
	private String email;
	
	@Column
	private String telephone;
	
	@Column(name="created_date") 
	private Date createdDate;
	
	@Column(name="customer_type") 
	private String customerType;
	
	@Column(name="created_by") 
	private String createdBy;

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public String getCustomerType() {
		return customerType;
	}

	public void setCustomerType(String string) {
		this.customerType = string;
	}
	
	
	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	
	
	
	
	
	
}
	