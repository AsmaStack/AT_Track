package com.amdocs.SpringApp1;

public class StudentModel {

	private long studid;
	private String stuname;
	private int age;
	
	private Address address;
	
	public StudentModel(long studid, String stuname, int age, Address address) {
		//super();
		this.studid = studid;
		this.stuname = stuname;
		this.age = age;
		this.address = address;
	}

	public StudentModel(long studid, String stuname, int age) {
		this.studid = studid;
		this.stuname = stuname;
		this.age = age;
	}
	
	
	public StudentModel(long studid, String stuname) {
		this.studid = studid;
		this.stuname = stuname;
		
	}
	
	
	
	
	public StudentModel(Address address) {
	
		this.address = address;
	}


	

	public StudentModel(long studid) {
		
		this.studid = studid;
	}
	public StudentModel(String stuname) {
		
		this.stuname = stuname;
	}
	public StudentModel(int age) {
	
		this.age = age;
	}


	@Override
	public String toString() {
		return "StudentModel [studid=" + studid + ","
				+ " stuname=" + stuname + ", "
						+ "age=" + age + ", "
								+ "address=" + address
				+ "]";
	}
	
	
	
	
	
	
}
