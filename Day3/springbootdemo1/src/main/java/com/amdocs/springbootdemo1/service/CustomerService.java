package com.amdocs.springbootdemo1.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amdocs.springbootdemo1.model.CustomerEntity;
import com.amdocs.springbootdemo1.repo.CustomerRepo;

@Service
public class CustomerService {

	
	private CustomerRepo custrepo;

	@Autowired
	public CustomerService(CustomerRepo custrepo) {
		
		this.custrepo = custrepo;
	}
	
	
	public boolean saveRecord(CustomerEntity customer )
	{
		CustomerEntity custsave= custrepo.save(customer);
		boolean flag=false;
		
		if(custsave!=null)
		{
			flag=true;
		}
				
		return flag;
	}
}
