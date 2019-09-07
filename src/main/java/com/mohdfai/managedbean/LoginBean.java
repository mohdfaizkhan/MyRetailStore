package com.mohdfai.managedbean;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@ManagedBean
@SessionScoped
public class LoginBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final Logger logger = LogManager.getLogger("LoginBean");

	private String userName;
	private String password;
	private boolean validCredentials = false;
	
	
	@PostConstruct
	public void init() {
	}

	public String onLogin() {

		if ("admin".equalsIgnoreCase(userName) && "admin123".equalsIgnoreCase(password)) {
			this.validCredentials = true;
			logger.info("loging successfull==========================================");
			return "/landing/landingPage.jsf";
		} else {
			this.validCredentials = false;
			FacesContext.getCurrentInstance().addMessage("loginBtn", new FacesMessage(
					"Please enter valid credentials"));
			return "/login/login.jsf";
		}

	}
	
	public void onClear() {
		this.userName = "";
		this.password = "";

	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isValidCredentials() {
		return validCredentials;
	}

	public void setValidCredentials(boolean validCredentials) {
		this.validCredentials = validCredentials;
	}

}
