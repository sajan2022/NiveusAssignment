package com.example.javaexample.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.javaexample.entity.Employee;
import com.example.javaexample.service.CrudService;

@RestController
@RequestMapping(path = "/api/employee/")
public class CrudController {
	
	@Autowired
	private CrudService crudService;
	
	@PostMapping("add_employee")
	public String addEmployee(@RequestBody Employee employee) {
		try {
			
			return crudService.addEmployee(employee);
			
		} catch (Exception e) {
			// TODO: handle exception
			
			System.out.println(" EXCEPTION FOUND | ADD EMPLOYEE  CONTROLLER | "+ e.getMessage());
			
			return "Controller Failed";
		}
	}
	
	@PutMapping("update_employee")
	public String updateEmployee(@RequestBody Employee employee) {
		try {
			
			return crudService.updateEmployee(employee);
			
		} catch (Exception e) {
			// TODO: handle exception
			
			System.out.println(" EXCEPTION FOUND | UPDATE EMPLOYEE CONTROLLER | "+ e.getMessage());
			return "Controller Failed";
		}
	}
	
	@DeleteMapping("delete_employee")
	public String deleteEmployee(@RequestParam("empId") Long id) {
		try {
			
			return crudService.deleteEmployee(id);
			
		} catch (Exception e) {
			// TODO: handle exception
			
			System.out.println(" EXCEPTION FOUND | DELETE EMPLOYEE CONTROLLER | "+ e.getMessage());
			
			return "Controller Failed";
		}
	}
	
	@GetMapping("view_employee")
	public List<Employee> viewEmployee(){
		
		try {
			
			return crudService.viewEmployee();
			
		} catch (Exception e) {
			
			System.out.println(" EXCEPTION FOUND | VIEW EMPLOYEE CONTROLLER | "+ e.getMessage());
			return null;
			
		}
	}
	
}
