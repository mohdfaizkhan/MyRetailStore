package com.mohdfai.managedbean;

import java.io.Serializable;
import java.util.Date;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.primefaces.PrimeFaces;
import org.primefaces.event.TabChangeEvent;

import com.mohdfai.dto.CommonUtils;
import com.mohdfai.dto.CustomerHolder;
import com.mohdfai.service.IRetailWebsiteService;

/**
 * @author mohdfai
 *
 */
@ManagedBean
@ViewScoped
public class LandingManagedBean implements Serializable{
	
	private static final Logger logger = LogManager.getLogger("LandingManagedBean");
	@Inject
	IRetailWebsiteService retailService;



	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String customerId;
	private boolean oldCustomer = false;
	private boolean billPanel = false;
	private CustomerHolder customerHolder = null;
	private CustomerHolder newCustomerHolder = null;
	private double groceryAmount = 0.0;
	private double nonGroceryAmount = 0.0;
	private double totalAmount = 0.0;
	private double discount = 0.0;
	private double totalPayableAmount = 0.0;
	private String discountPercentage = null;


	@PostConstruct
	public void init() {
		this.oldCustomer = false;
		this.billPanel = false;
		this.customerHolder = new CustomerHolder();
		this.newCustomerHolder = new CustomerHolder();
		customerId = "";
		
	}
	
	/**
	 * This method is called when user searches for Customer to fetch the customer details
	 */
	public void onCustomerSearch() {
		
			CustomerHolder customerData = getRetailService().loadCustomerDetails(customerId);

			if (null != customerData && null != customerData.getCustomerId()
					&& customerData.getCustomerId().length() > 0) {
				this.oldCustomer = true;
				customerHolder = new CustomerHolder();
				customerHolder = customerData;

			} else {
				FacesContext.getCurrentInstance().addMessage("mainForm:custId", new FacesMessage(
						"Customer not registered, Kindly register using the Register customer option in next Tab"));
				this.oldCustomer = false;
			}

		
	}
	
	  public void onTabChange(TabChangeEvent event) {
		  init();
	    }
	

	/**
	 * This method returns the Bill invoice with the Total payable amount and discount details
	 */
	public void onGenerateBill() {
		if (doAmountValidation()) {
			
			totalAmount = groceryAmount + nonGroceryAmount;

			switch (customerHolder.getCustomerType().toUpperCase()) {
			case "EMPLOYEE":
                discount = nonGroceryAmount * (0.3);
                this.discountPercentage = "30 %";
				break;
				
			case "AFFILIATE":
				discount = nonGroceryAmount * (0.1);
				this.discountPercentage = "10 %";
				break;
				
			case "CUSTOMER":
				if(CommonUtils.getDiffYears(customerHolder.getCreatedDate(), new Date()) >=2) {
                  discount = nonGroceryAmount * (0.05);
                  this.discountPercentage = "5 %";
                  
				} else {
			      discount = 0.0;
			      this.discountPercentage = "0 %";
				}
				break;

			default:
				break;
			}
			
			if(groceryAmount > 100) {
				
				discount = discount + (((int) groceryAmount/100) * 5);
			}
			logger.info("===============================discount = "+discount);
			totalPayableAmount = totalAmount - discount;
			
			PrimeFaces current = PrimeFaces.current();
			current.executeScript("PF('billDialogVar').show();");
			

		}
		
	}
	
    /**
     * This method is used to perform validations
     * @return true or false
     */
    private boolean doAmountValidation() {
    	if(groceryAmount <= 0 && nonGroceryAmount <= 0 ) {
			 FacesContext.getCurrentInstance().addMessage("mainForm:grosAmt", new FacesMessage("Enter a valid amount"));
			 FacesContext.getCurrentInstance().addMessage("mainForm:nonGrosAmt", new FacesMessage("Enter a valid amount"));
			 return false;
    	}
		return true;
	}

	/**
	 * This method is used for Enabling bill entry fields
	 */
	public void onBillEntry() {
		
		this.billPanel = true;
	}
	
	/**
	 * Clears the entered values and refreshes the screen
	 */
	public void onClearSearch() {
		init();
	}
	
	/**
	 * Clears the entered vaalues in the amount fields
	 */
	public void onClearBill() {
		this.groceryAmount = 0.0;
		this.nonGroceryAmount = 0.0;
	}
	
	/**
	 * This method is used to register the new customer for the store
	 */
	public void onRegisterCustomer() {
		
		newCustomerHolder.setCreatedDate(new Date());
		
		String status = getRetailService().registerNewCustomer(newCustomerHolder);
		
		if(null!= status && status.length()>0 && "Success".equalsIgnoreCase(status)) {
			newCustomerHolder=new CustomerHolder();
			FacesContext.getCurrentInstance().addMessage("mainForm:regBtn", new FacesMessage("Customer Added Successfully!"));

		} else {
			FacesContext.getCurrentInstance().addMessage("mainForm:regBtn", new FacesMessage("Customer Addition failed!"));
		}
		
	}


	/**
	 * This method is called when user clicks cancel from Home tab
	 */
	public void onCancel() {
		this.newCustomerHolder = new CustomerHolder();
	}
	

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}


	public CustomerHolder getCustomerHolder() {
		return customerHolder;
	}

	public void setCustomerHolder(CustomerHolder customerHolder) {
		this.customerHolder = customerHolder;
	}

	public boolean isOldCustomer() {
		return oldCustomer;
	}

	public void setOldCustomer(boolean oldCustomer) {
		this.oldCustomer = oldCustomer;
	}

	public boolean isBillPanel() {
		return billPanel;
	}

	public void setBillPanel(boolean billPanel) {
		this.billPanel = billPanel;
	}

	public double getGroceryAmount() {
		return groceryAmount;
	}

	public void setGroceryAmount(double groceryAmount) {
		this.groceryAmount = groceryAmount;
	}

	public double getNonGroceryAmount() {
		return nonGroceryAmount;
	}

	public void setNonGroceryAmount(double nonGroceryAmount) {
		this.nonGroceryAmount = nonGroceryAmount;
	}
	
	public double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}

	public double getDiscount() {
		return discount;
	}

	public void setDiscount(double discount) {
		this.discount = discount;
	}

	public double getTotalPayableAmount() {
		return totalPayableAmount;
	}

	public void setTotalPayableAmount(double totalPayableAmount) {
		this.totalPayableAmount = totalPayableAmount;
	}

	public CustomerHolder getNewCustomerHolder() {
		return newCustomerHolder;
	}

	public void setNewCustomerHolder(CustomerHolder newCustomerHolder) {
		this.newCustomerHolder = newCustomerHolder;
	}
	
	public IRetailWebsiteService getRetailService() {
		return retailService;
	}

	public void setRetailService(IRetailWebsiteService retailService) {
		this.retailService = retailService;
	}

	public String getDiscountPercentage() {
		return discountPercentage;
	}

	public void setDiscountPercentage(String discountPercentage) {
		this.discountPercentage = discountPercentage;
	}
	
}
