package com.mohdfai.controller;

import javax.inject.Inject;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mohdfai.model.Bill;
import com.mohdfai.model.User;
import com.mohdfai.service.RetailService;

@RestController
@RequestMapping("/retail")
public class RetailController {
	
	@Inject
	private RetailService service;
	
	@PostMapping("/bill")
	public Bill generateBill(@RequestBody User user) {
		return service.generateBill(user);
		
	}

}
