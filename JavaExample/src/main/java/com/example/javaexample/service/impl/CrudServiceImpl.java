package com.example.javaexample.service.impl;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.javaexample.dto.EmployeeDTO;
import com.example.javaexample.entity.Employee;
import com.example.javaexample.repository.CrudRepository;
import com.example.javaexample.service.CrudService;

@Component
public class CrudServiceImpl implements CrudService{
	
	@Autowired
	private CrudRepository crudRepository;
	
	@Override
	public EmployeeDTO addEmployee(Employee employee) {
		// TODO Auto-generated method stub
		
		try {
			Employee employeeInfo = crudRepository.save(employee);
			
			EmployeeDTO employeeDTO = new EmployeeDTO();
			employeeDTO.setId(employeeInfo.getId());
			employeeDTO.setEmpName(employeeInfo.getEmpName());
			employeeDTO.setDepartment(employeeInfo.getDepartment());
			
			return employeeDTO;
			
		} catch (Exception e) {
			// TODO: handle exception
			
			System.out.println(" EXCEPTION FOUND | ADD EMPLOYEE | "+ e.getMessage());
			return null;
		}
	
	}

	@Override
	public EmployeeDTO updateEmployee(Employee employee) {
		try {
			
			Employee employeeInfo = crudRepository.save(employee);
			
			EmployeeDTO employeeDTO = new EmployeeDTO();
			employeeDTO.setId(employeeInfo.getId());
			employeeDTO.setEmpName(employeeInfo.getEmpName());
			employeeDTO.setDepartment(employeeInfo.getDepartment());
			
			return employeeDTO;
			
		} catch (Exception e) {
			// TODO: handle exception
			
			System.out.println(" EXCEPTION FOUND | UPDATE EMPLOYEE | "+ e.getMessage());
			
			return null;
		}
	}

	@Override
	public EmployeeDTO deleteEmployee(Long id) {
		try {
			
			Employee employeeInfo = crudRepository.findById(id).orElseGet(null);
			crudRepository.deleteById(id);
			
			EmployeeDTO employeeDTO = new EmployeeDTO();
			employeeDTO.setId(employeeInfo.getId());
			employeeDTO.setEmpName(employeeInfo.getEmpName());
			employeeDTO.setDepartment(employeeInfo.getDepartment());
			
			return employeeDTO;
			
		} catch (Exception e) {
			// TODO: handle exception
			
			System.out.println(" EXCEPTION FOUND | DELETE EMPLOYEE | "+ e.getMessage());
			
			return null;
		}
	}

	@Override
	public List<Employee> viewEmployee() {
		try {
			
			return crudRepository.findAll();
			
		} catch (Exception e) {
			// TODO: handle exception
			
			System.out.println(" EXCEPTION FOUND | VIEW EMPLOYEE | "+ e.getMessage());
			
			return Collections.emptyList();
		}
	}

}
