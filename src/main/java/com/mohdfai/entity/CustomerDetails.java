package com.mohdfai.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author mohdfai
 *
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
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
}
	