package com.junit.demo.service;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.junit.demo.entity.EmployeeEntity;
import com.junit.demo.repository.EmployeeRepository;

@SpringBootTest
public class EmployeeServiceTest {

	@Autowired
	EmployeeRepository employeeRepository;
	
	public static final String EMAIL_REGEX="[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}";
	
	@Test
	public void testFindAll() {
		assertNotNull(employeeRepository.findAll());
	}
	
	@Test
	public void testFindAllWithEmail() {
		List<EmployeeEntity> employeeEntity = employeeRepository.findAll();
		assertTrue(!employeeEntity.stream().map(v -> !v.getEmail().isEmpty()).collect(Collectors.toList()).isEmpty());
	}
	
	@Test
	@Disabled
	public void testFindAllvalidEmail() {
		List<EmployeeEntity> employeeEntity = employeeRepository.findAll();
		assertTrue(employeeEntity.stream().map(v -> v.getEmail().matches(EMAIL_REGEX)).collect(Collectors.toList())
				.isEmpty());
	}
	
	@ParameterizedTest
	@ValueSource(strings = {
		"johndoe@mail.com", "stevesmith@mail.com"
	})
	public void testFindAllEmployeesByEmail(String email) {
		assertNotNull(employeeRepository.findByEmail(email), "failed for "+email);
	}
	
}
