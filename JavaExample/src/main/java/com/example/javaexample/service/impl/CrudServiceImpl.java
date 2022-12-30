package com.example.javaexample.service.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import com.example.javaexample.dto.EmployeeDTO;
import com.example.javaexample.entity.Employee;
import com.example.javaexample.repository.CrudRepository;
import com.example.javaexample.service.CrudService;
import com.example.javaexample.util.ServiceResponse;

@Component
public class CrudServiceImpl implements CrudService{
	
	@Autowired
	private CrudRepository crudRepository;
	
	@Override
	public ServiceResponse<EmployeeDTO> addEmployee(EmployeeDTO employeeDto) {
		
		try {
			
			Employee employee = new Employee();
			employee.setEmpName(employeeDto.getEmpName());
			employee.setDepartment(employeeDto.getDepartment());
			employee.setYearOfJoin(employeeDto.getYearOfJoin());
			
			Employee employeeInfo = crudRepository.save(employee);
			
			EmployeeDTO employeeResult = new EmployeeDTO();
			employeeResult.setId(employeeInfo.getId());
			employeeResult.setEmpName(employeeInfo.getEmpName());
			employeeResult.setDepartment(employeeInfo.getDepartment());
			employeeResult.setYearOfJoin(employeeInfo.getYearOfJoin());
			
			return new ServiceResponse<>(HttpStatus.CREATED,"Added Successfully",employeeResult);
			
		} catch (Exception e) {

			System.out.println(" EXCEPTION FOUND | ADD EMPLOYEE | "+ e.getMessage());
			return new ServiceResponse<>(HttpStatus.INTERNAL_SERVER_ERROR,"Please Contact support",null);
			
		}
	
	}

	@Override
	public  ServiceResponse<EmployeeDTO> updateEmployee(EmployeeDTO employeeDto) {
		try {
			
			Employee employee = new Employee();
			employee.setId(employeeDto.getId());
			employee.setEmpName(employeeDto.getEmpName());
			employee.setDepartment(employeeDto.getDepartment());
			employee.setYearOfJoin(employeeDto.getYearOfJoin());
			
			Employee employeeInfo = crudRepository.save(employee);
			
			EmployeeDTO employeeResult = new EmployeeDTO();
			employeeResult.setId(employeeInfo.getId());
			employeeResult.setEmpName(employeeInfo.getEmpName());
			employeeResult.setDepartment(employeeInfo.getDepartment());
			employeeResult.setYearOfJoin(employeeInfo.getYearOfJoin());
			
			return new ServiceResponse<>(HttpStatus.OK,"updated Successfully",employeeResult);
			
		} catch (Exception e) {
			
			System.out.println(" EXCEPTION FOUND | UPDATE EMPLOYEE | "+ e.getMessage());
			return new ServiceResponse<>(HttpStatus.INTERNAL_SERVER_ERROR,"Please Contact support",null);
			
		}
	}

	@Override
	public ServiceResponse<EmployeeDTO> deleteEmployee(Long id) {
		try {
			
			Employee employeeInfo = crudRepository.findById(id).orElse(null);
			
			System.out.println("employeeInfo "+ employeeInfo);
			
			EmployeeDTO employeeResult = new EmployeeDTO();
			if(employeeInfo != null) {
				employeeResult.setId(employeeInfo.getId());
				employeeResult.setEmpName(employeeInfo.getEmpName());
				employeeResult.setDepartment(employeeInfo.getDepartment());
				employeeResult.setYearOfJoin(employeeInfo.getYearOfJoin());
				crudRepository.deleteById(id);
			}else {
				return new ServiceResponse<>(HttpStatus.BAD_REQUEST,"Invalid employee id",null);
			}
		
			
			return new ServiceResponse<>(HttpStatus.OK,"Deleted Successfully",employeeResult);
			
		} catch (Exception e) {
			
			System.out.println(" EXCEPTION FOUND | DELETE EMPLOYEE | "+ e.getMessage());
			return new ServiceResponse<>(HttpStatus.INTERNAL_SERVER_ERROR,"Please Contact support",null);
		}
	}

	@Override
	public ServiceResponse<List<EmployeeDTO>> viewEmployee() {
		try {
			
			List<EmployeeDTO> employeeList = new ArrayList<>();
			crudRepository.findAll().forEach((employeeInfo)->{
				EmployeeDTO employeeDTO = new EmployeeDTO();
				employeeDTO.setId(employeeInfo.getId());
				employeeDTO.setEmpName(employeeInfo.getEmpName());
				employeeDTO.setDepartment(employeeInfo.getDepartment());
				employeeDTO.setYearOfJoin(employeeInfo.getYearOfJoin());
				employeeList.add(employeeDTO);
			});
			
			return new ServiceResponse<>(HttpStatus.OK,"Employee Details",employeeList);
			
		} catch (Exception e) {
			
			System.out.println(" EXCEPTION FOUND | VIEW EMPLOYEE | "+ e.getMessage());
			return new ServiceResponse<>(HttpStatus.INTERNAL_SERVER_ERROR,"Please Contact support",null);
			
		}
	}

	@Override
	public ServiceResponse<List<EmployeeDTO>> searchEmployee(String type, String value) {
	
	try {
		
			return new ServiceResponse<>(HttpStatus.OK,"Employee Details",fetchEmployeeInfo(type,value));
			
		} catch (Exception e) {
			
			System.out.println(" EXCEPTION FOUND | VIEW EMPLOYEE | "+ e.getMessage());
			return new ServiceResponse<>(HttpStatus.INTERNAL_SERVER_ERROR,"Please Contact support",null);
			
		}
	
	}
	
	
	public List<EmployeeDTO> fetchEmployeeInfo(String type, String value){
		
		try {
			
			List<EmployeeDTO> employeeList = new ArrayList<>();
			if(type.equalsIgnoreCase("NAME")) {
				
				crudRepository.findByName(value).forEach((employeeInfo)->{
					EmployeeDTO employeeDTO = new EmployeeDTO();
					employeeDTO.setId(employeeInfo.getId());
					employeeDTO.setEmpName(employeeInfo.getEmpName());
					employeeDTO.setDepartment(employeeInfo.getDepartment());
					employeeDTO.setYearOfJoin(employeeInfo.getYearOfJoin());
					employeeList.add(employeeDTO);
				});
				
				
			}else if(type.equalsIgnoreCase("DEPARTMENT")){
				
				crudRepository.findByDepartment(value).forEach((employeeInfo)->{
					EmployeeDTO employeeDTO = new EmployeeDTO();
					employeeDTO.setId(employeeInfo.getId());
					employeeDTO.setEmpName(employeeInfo.getEmpName());
					employeeDTO.setDepartment(employeeInfo.getDepartment());
					employeeDTO.setYearOfJoin(employeeInfo.getYearOfJoin());
					employeeList.add(employeeDTO);
				});
				
			}
			
			
			
			return employeeList;
			
		} catch (Exception e) {
			return Collections.emptyList();
		}
		
	}
}
