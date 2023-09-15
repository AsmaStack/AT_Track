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
	private String custname;

	public CustomerEntity() {
		// TODO Auto-generated constructor stub
	}

	public CustomerEntity(int custid, String custname) {
		//super();
		this.custid = custid;
		this.custname = custname;
	}

	public int getCustid() {
		return custid;
	}

	public void setCustid(int custid) {
		this.custid = custid;
	}

	public String getCustname() {
		return custname;
	}

	public void setCustname(String custname) {
		this.custname = custname;
	}

}
