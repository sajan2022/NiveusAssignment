package com.example.javaexample.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.javaexample.dto.EmployeeDTO;
import com.example.javaexample.entity.Employee;

@Service
public interface CrudService {
	
	public EmployeeDTO addEmployee(Employee employee);
	public EmployeeDTO updateEmployee(Employee employee);
	public EmployeeDTO deleteEmployee(Long id);
	public List<Employee> viewEmployee();
	
}
