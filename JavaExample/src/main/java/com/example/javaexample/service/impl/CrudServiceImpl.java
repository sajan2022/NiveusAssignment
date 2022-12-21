package com.example.javaexample.service.impl;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.javaexample.entity.Employee;
import com.example.javaexample.repository.CrudRepository;
import com.example.javaexample.service.CrudService;

@Component
public class CrudServiceImpl implements CrudService{
	
	@Autowired
	private CrudRepository crudRepository;
	
	@Override
	public String addEmployee(Employee employee) {
		// TODO Auto-generated method stub
		
		try {
			
			crudRepository.save(employee);
			return "employee added";
			
		} catch (Exception e) {
			// TODO: handle exception
			
			System.out.println(" EXCEPTION FOUND | ADD EMPLOYEE | "+ e.getMessage());
			
			return "employee adding failed";
		}
	
	}

	@Override
	public String updateEmployee(Employee employee) {
		try {
			
			crudRepository.save(employee);
			return "employee updated";
			
		} catch (Exception e) {
			// TODO: handle exception
			
			System.out.println(" EXCEPTION FOUND | UPDATE EMPLOYEE | "+ e.getMessage());
			
			return "employee updating failed";
		}
	}

	@Override
	public String deleteEmployee(Long id) {
		try {
			
			crudRepository.deleteById(id);
			return "employee deleted";
			
		} catch (Exception e) {
			// TODO: handle exception
			
			System.out.println(" EXCEPTION FOUND | DELETE EMPLOYEE | "+ e.getMessage());
			
			return "employee delete failed";
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
