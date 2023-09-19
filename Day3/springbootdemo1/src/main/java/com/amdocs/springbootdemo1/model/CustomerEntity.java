package com.amdocs.springbootdemo1.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class CustomerEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int custid;
	private String first_Name;
	//private String lastName;
	public CustomerEntity() {
		// TODO Auto-generated constructor stub
	}

	public CustomerEntity(int custid, String first_Name) {
		//super();
		this.custid = custid;
		this.first_Name = first_Name;
		//this.lastName=lastName;
	}

	public int getCustid() {
		return custid;
	}

	public void setCustid(int custid) {
		this.custid = custid;
	}

	public String getFirstname() {
		return first_Name;
	}

	public void setFirstname(String first_Name) {
		this.first_Name = first_Name;
	}

	

	

}
