package com.shiva.service;

import java.util.List;

import com.shiva.entity.Employee;

public interface EmployeeService {

	public boolean saveEmployee(Employee emp);
	
	public List<Employee> getAllEmployees();
	
	public Employee getEmployeeId(int id);

	public boolean updateBook(Employee st);

	public boolean deleteEmployee(int id);
	



	
	
	
}


