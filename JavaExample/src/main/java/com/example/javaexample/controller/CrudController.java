package com.example.javaexample.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.javaexample.dto.EmployeeDTO;
import com.example.javaexample.entity.Employee;
import com.example.javaexample.service.CrudService;

@RestController
@RequestMapping(path = "/api/employee/")
public class CrudController {
	
	@Autowired
	private CrudService crudService;
	
	@PostMapping("add_employee")
	public ResponseEntity<EmployeeDTO> addEmployee(@RequestBody Employee employee) {
		try {
			
			return new ResponseEntity<>(crudService.addEmployee(employee), HttpStatus.CREATED);
			
		} catch (Exception e) {
			// TODO: handle exception
			
			System.out.println(" EXCEPTION FOUND | ADD EMPLOYEE  CONTROLLER | "+ e.getMessage());
			
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PutMapping("update_employee")
	public ResponseEntity<EmployeeDTO> updateEmployee(@RequestBody Employee employee) {
		try {
			
			return new ResponseEntity<>(crudService.updateEmployee(employee),HttpStatus.OK);
			
		} catch (Exception e) {
			// TODO: handle exception
			
			System.out.println(" EXCEPTION FOUND | UPDATE EMPLOYEE CONTROLLER | "+ e.getMessage());
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@DeleteMapping("delete_employee")
	public ResponseEntity<EmployeeDTO>  deleteEmployee(@RequestParam("empId") Long id) {
		try {
			
			return new ResponseEntity<>(crudService.deleteEmployee(id),HttpStatus.OK);
			
		} catch (Exception e) {
			// TODO: handle exception
			
			System.out.println(" EXCEPTION FOUND | DELETE EMPLOYEE CONTROLLER | "+ e.getMessage());
			
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("view_employee")
	public ResponseEntity<List<Employee>> viewEmployee(){
		
		try {
			
			return new ResponseEntity<>(crudService.viewEmployee(),HttpStatus.OK);
			
		} catch (Exception e) {
			
			System.out.println(" EXCEPTION FOUND | VIEW EMPLOYEE CONTROLLER | "+ e.getMessage());
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
			
		}
	}
	
}
