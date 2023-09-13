package com.amdocs.SpringApp1;

public class Address {

	
	private String state,city;

	

	public void setState(String state) {
		this.state = state;
	}
	
	public void setCity(String city) {
		this.city = city;
	}

	@Override
	public String toString() {
		return "Address [state=" + state + ", city=" + city + "]";
	}

	
	
	
}
