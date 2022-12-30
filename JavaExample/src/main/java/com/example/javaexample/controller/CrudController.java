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
import com.example.javaexample.service.CrudService;
import com.example.javaexample.util.Response;
import com.example.javaexample.util.ServiceResponse;

@RestController
@RequestMapping(path = "/api/employee/")
public class CrudController {
	
	
	@Autowired
	private CrudService crudService;
	
	@PostMapping("addEmployee")
	public ResponseEntity<Response> addEmployee(@RequestBody EmployeeDTO employeeDto) {
		try {
			Response response;
			ServiceResponse<EmployeeDTO> serviceResponse = crudService.addEmployee(employeeDto);
			
			if(serviceResponse.getStatus() == HttpStatus.CREATED) {
				
				response = new Response(serviceResponse.getStatus(), serviceResponse.getMessage(), serviceResponse.getT());
				return new ResponseEntity<>(response, serviceResponse.getStatus());
				
			}else {
				
				response = new Response(serviceResponse.getStatus(), serviceResponse.getMessage(), null);
				return new ResponseEntity<>(response, serviceResponse.getStatus());
				
			}
			
		} catch (Exception e) {
			
			System.out.println(" EXCEPTION FOUND | ADD EMPLOYEE  CONTROLLER | "+ e.getMessage());
			
			return new ResponseEntity<>(new Response(HttpStatus.INTERNAL_SERVER_ERROR, "Please Contact customer support", null),HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PutMapping("updateEmployee")
	public ResponseEntity<Response> updateEmployee(@RequestBody EmployeeDTO employeeDto) {
		try {
			
			Response response;
			ServiceResponse<EmployeeDTO> serviceResponse = crudService.updateEmployee(employeeDto);
			
			if(serviceResponse.getStatus() == HttpStatus.OK) {
				
				response = new Response(serviceResponse.getStatus(), serviceResponse.getMessage(), serviceResponse.getT());
				return new ResponseEntity<>(response, serviceResponse.getStatus());
				
			}else {
				
				response = new Response(serviceResponse.getStatus(), serviceResponse.getMessage(), null);
				return new ResponseEntity<>(response, serviceResponse.getStatus());
				
			}
			
			
		} catch (Exception e) {
			
			System.out.println(" EXCEPTION FOUND | UPDATE EMPLOYEE CONTROLLER | "+ e.getMessage());
			return new ResponseEntity<>(new Response(HttpStatus.INTERNAL_SERVER_ERROR, "Please Contact customer support", null),HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@DeleteMapping("deleteEmployee")
	public ResponseEntity<Response>  deleteEmployee(@RequestParam("empId") Long id) {
		try {
			
			Response response;
			ServiceResponse<EmployeeDTO> serviceResponse = crudService.deleteEmployee(id);
			
			if(serviceResponse.getStatus() == HttpStatus.OK) {
				
				response = new Response(serviceResponse.getStatus(), serviceResponse.getMessage(), serviceResponse.getT());
				return new ResponseEntity<>(response, serviceResponse.getStatus());
				
			}else {
				
				response = new Response(serviceResponse.getStatus(), serviceResponse.getMessage(), null);
				return new ResponseEntity<>(response, serviceResponse.getStatus());
				
			}
			
		} catch (Exception e) {
			
			System.out.println(" EXCEPTION FOUND | DELETE EMPLOYEE CONTROLLER | "+ e.getMessage());
			
			return new ResponseEntity<>(new Response(HttpStatus.INTERNAL_SERVER_ERROR, "Please Contact customer support", null),HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("viewEmployee")
	public ResponseEntity<Response> viewEmployee(){
		
		try {
			
			Response response;
			ServiceResponse<List<EmployeeDTO>> serviceResponse = crudService.viewEmployee();
			
			if(serviceResponse.getStatus() == HttpStatus.OK) {
				
				response = new Response(serviceResponse.getStatus(), serviceResponse.getMessage(), serviceResponse.getT());
				return new ResponseEntity<>(response, serviceResponse.getStatus());
				
			}else {
				
				response = new Response(serviceResponse.getStatus(), serviceResponse.getMessage(), null);
				return new ResponseEntity<>(response, serviceResponse.getStatus());
				
			}
			
		} catch (Exception e) {
			
			System.out.println(" EXCEPTION FOUND | VIEW EMPLOYEE CONTROLLER | "+ e.getMessage());
			return new ResponseEntity<>(new Response(HttpStatus.INTERNAL_SERVER_ERROR, "Please Contact customer support", null),HttpStatus.INTERNAL_SERVER_ERROR);
			
		}
	}
	
	
	@GetMapping("searchEmployee")
	public ResponseEntity<Response> viewEmployee(@RequestParam("type") String type, @RequestParam("value") String value){
		
		try {
			
			Response response;
			ServiceResponse<List<EmployeeDTO>> serviceResponse = crudService.searchEmployee(type,value);
			
			if(serviceResponse.getStatus() == HttpStatus.OK) {
				
				response = new Response(serviceResponse.getStatus(), serviceResponse.getMessage(), serviceResponse.getT());
				return new ResponseEntity<>(response, serviceResponse.getStatus());
				
			}else {
				
				response = new Response(serviceResponse.getStatus(), serviceResponse.getMessage(), null);
				return new ResponseEntity<>(response, serviceResponse.getStatus());
				
			}
			
		} catch (Exception e) {
			
			System.out.println(" EXCEPTION FOUND | VIEW EMPLOYEE CONTROLLER | "+ e.getMessage());
			return new ResponseEntity<>(new Response(HttpStatus.INTERNAL_SERVER_ERROR, "Please Contact customer support", null),HttpStatus.INTERNAL_SERVER_ERROR);
			
		}
	}
}
