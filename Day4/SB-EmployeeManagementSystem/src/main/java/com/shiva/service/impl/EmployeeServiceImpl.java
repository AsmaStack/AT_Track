package com.shiva.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shiva.entity.Employee;
import com.shiva.repo.EmployeeRepository;
import com.shiva.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository empRepo;

	@Override
	public boolean saveEmployee(Employee emp) {
		// TODO Auto-generated method stub

		// interact db s/w to store data into the database

		Employee empSave = empRepo.save(emp);
		boolean flag = false;

		if (empSave != null)
			flag = true;

		return flag;
	}

	@Override
	public List<Employee> getAllEmployees() {
		// TODO Auto-generated method stub
		//select *from employee;
		List<Employee> empRecords = empRepo.findAll();
		return empRecords;
	}

	@Override
	public Employee getEmployeeId(int id) {
		// TODO Auto-generated method stub
		//select *From employee where eno=?;
		Optional<Employee> empId = empRepo.findById(id);
		Employee emp = empId.get();
		return emp;
	}
	

	@Override
	public boolean updateBook(Employee st) {
		// TODO Auto-generated method stub
		
		//Record is exist or not have to check once record is exist then update the data
		
			
		
		return saveEmployee(st);
	}

	@Override
	public boolean deleteEmployee(int id) {
		// TODO Auto-generated method stub
		//Record is exist or not have to check first then delete
		Employee emp = getEmployeeId(id);
		boolean flag=false;
		if(emp!=null)
		{
			empRepo.delete(emp);
		flag=true;	
		}
		
			
		
		return flag;
		
		
	}

}
