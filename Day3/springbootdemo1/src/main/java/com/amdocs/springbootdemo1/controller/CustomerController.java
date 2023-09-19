package com.amdocs.springbootdemo1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.amdocs.springbootdemo1.model.CustomerEntity;
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
	public String indexPage(Model model)
	{ 	
		model.addAttribute("customer", new CustomerEntity());
		return "customerreg";
	}
	
	@RequestMapping(value="/savecustomer", method=RequestMethod.POST)
	public String saveRecord(@ModelAttribute("cust") CustomerEntity customer,Model model)
	{
boolean saveEmployee = custserv.saveRecord(customer);
		
		String msg="";
		
		if(saveEmployee)
			msg="Data Inserted SuccessFully";
		else
			msg="Data Not Inserted SuccessFully";
		
		model.addAttribute("msg", msg);
		return "home";
		
		
	}
	
	
}
