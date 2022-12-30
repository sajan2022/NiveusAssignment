package com.example.javaexample.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.javaexample.dto.EmployeeDTO;
import com.example.javaexample.util.ServiceResponse;

@Service
public interface CrudService {
	
	public ServiceResponse<EmployeeDTO> addEmployee(EmployeeDTO employeeDTO);
	public ServiceResponse<EmployeeDTO> updateEmployee(EmployeeDTO employeeDTO);
	public ServiceResponse<EmployeeDTO> deleteEmployee(Long id);
	public ServiceResponse<List<EmployeeDTO>> viewEmployee();
	
	public ServiceResponse<List<EmployeeDTO>> searchEmployee(String type,String value);
	
}
