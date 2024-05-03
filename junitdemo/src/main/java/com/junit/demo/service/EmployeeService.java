package com.junit.demo.service;

import com.junit.demo.entity.EmployeeEntity;
import com.junit.demo.utility.Result;

public interface EmployeeService {

	public Result getAllEmployeeDetails();
	
	public void saveEmployee(EmployeeEntity employeeEntity);
	
	public Result getEmployeeByEmail(String email);
}
