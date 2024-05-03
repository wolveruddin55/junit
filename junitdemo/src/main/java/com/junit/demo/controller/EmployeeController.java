package com.junit.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.junit.demo.entity.EmployeeEntity;
import com.junit.demo.service.EmployeeServiceImpl;
import com.junit.demo.utility.Result;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
public class EmployeeController {
	
	@Autowired
	EmployeeServiceImpl employeeServiceImpl;
	
	@GetMapping("/get-all-employee-details")
	public Result getAllEmployeeDetails() {
		return employeeServiceImpl.getAllEmployeeDetails();
	}
	
	@PostMapping("/save-employee")
	public String saveEmployee(@RequestBody EmployeeEntity entity) {
		employeeServiceImpl.saveEmployee(entity);
		return "success";
	}
	
	@GetMapping("/get-employee-by-email")
	public Result getEmployeeEmail(@RequestParam String email) {
		 return employeeServiceImpl.getEmployeeByEmail(email);
	}
}
