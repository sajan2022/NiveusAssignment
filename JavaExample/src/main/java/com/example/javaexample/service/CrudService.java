package com.example.javaexample.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.javaexample.entity.Employee;

@Service
public interface CrudService {
	
	public String addEmployee(Employee employee);
	public String updateEmployee(Employee employee);
	public String deleteEmployee(Long id);
	public List<Employee> viewEmployee();
	
}
