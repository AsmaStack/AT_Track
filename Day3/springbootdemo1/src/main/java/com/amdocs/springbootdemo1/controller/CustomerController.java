package com.amdocs.springbootdemo1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.amdocs.springbootdemo1.service.CustomerService;

@Controller
@RequestMapping("/customer")
public class CustomerController {

	private CustomerService custserv;

	@Autowired
	public CustomerController(CustomerService custserv) {
		//super();
		this.custserv = custserv;
	}
	//http://localhost:8085/customer/index
	@RequestMapping("/index")
	public String indexPage()
	{
		return "customerreg";
	}
	
	
}
