package com.amdocs.SpringBootCustomer.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.amdocs.SpringBootCustomer.model.Customers;
import com.amdocs.SpringBootCustomer.repo.CustomerRepo;
import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {
	    private CustomerRepo customerRepository;

	    @Autowired
	    public CustomerService(CustomerRepo customerRepository) {
	    	this.customerRepository = customerRepository;
	    }

		public Customers createCustomer(Customers customer) {
	        return customerRepository.save(customer);
	    }

	    public List<Customers> getAllCustomers() {
	        return customerRepository.findAll();
	    }

	    public Optional<Customers> getCustomerById(Long customerId) {
	        return customerRepository.findById(customerId);
	    }
	}



