package com.junit.demo.service;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.junit.demo.entity.EmployeeEntity;
import com.junit.demo.repository.EmployeeRepository;
import com.junit.demo.utility.Result;

@Service
public class EmployeeServiceImpl implements EmployeeService{

	@Autowired
	EmployeeRepository employeeRepository;
	
	@Override
	public Result getAllEmployeeDetails() {
		List<EmployeeEntity> employeeEntities= employeeRepository.findAll();
		Result result= new Result();
		result.setData(employeeEntities);
		result.setStatusCode(HttpStatus.OK.value());
		result.setMessage("getting records");
		return result;
	}

	@Override
	public void saveEmployee(EmployeeEntity employeeEntity) {
		employeeRepository.save(employeeEntity);
	}

	@Override
	public Result getEmployeeByEmail(String email) {
		List<EmployeeEntity> employeeEntities= employeeRepository.findByEmail(email);
		Result result= new Result();
		if(!employeeEntities.isEmpty()) {
			result= new Result();
			result.setStatusCode(HttpStatus.OK.value());
			result.setData(Collections.EMPTY_LIST);
			result.setMessage(email+ " exists");
		}else {
			result= new Result();
			result.setStatusCode(HttpStatus.NOT_FOUND.value());
			result.setData(Collections.EMPTY_LIST);
			result.setMessage(email+ " does not exists");
		}
		return result;
	}

}
