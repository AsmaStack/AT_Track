package com.amdocs.SpringBootCustomer.exception;

public class CustomerNotExistException extends Exception {
	
	public CustomerNotExistException(String Message) {
		
		System.out.println(Message);
	}

}
