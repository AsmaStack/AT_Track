package com.shiva.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.shiva.entity.Employee;
@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

	//findByxxx
	//Customized queries
}
