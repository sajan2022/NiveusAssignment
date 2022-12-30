package com.example.javaexample;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.example.javaexample.dto.EmployeeDTO;
import com.example.javaexample.entity.Employee;
import com.example.javaexample.repository.CrudRepository;

@ExtendWith(SpringExtension.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class CrudTest {
	
	@Autowired
	private CrudRepository crudRepository;
	
	@Test
	@Order(1)
	void addEmployeeTest() {
		
		EmployeeDTO employeeDTO = new EmployeeDTO();
		employeeDTO.setEmpName("Kiran");
		employeeDTO.setDepartment("IT");
		
		Employee employeeInfo = new Employee();
		employeeInfo.setEmpName(employeeDTO.getEmpName());
		employeeInfo.setDepartment(employeeDTO.getDepartment());
		
		employeeInfo = crudRepository.save(employeeInfo);
		
		assertNotNull(employeeInfo);
		org.assertj.core.api.Assertions.assertThat(employeeInfo.getId()).isGreaterThan(0);

	}
	
	@Test
	@Order(2)
	void updateEmployeeTest() {
		
		EmployeeDTO employeeDTO = new EmployeeDTO();
		employeeDTO.setId(6L);
		employeeDTO.setEmpName("Rohan");
		
		Employee employeeInfo = new Employee();
		employeeInfo.setId(employeeDTO.getId());
		employeeInfo.setEmpName(employeeDTO.getEmpName());
		
		employeeInfo = crudRepository.save(employeeInfo);
		
		assertEquals(employeeDTO.getEmpName(), employeeInfo.getEmpName());
		
	}
	
	@Test
	@Order(3)
	void deleteEmployeeTest() {
		
		
		Employee employeeInfo = crudRepository.findById(8L).orElse(null);
		crudRepository.delete(employeeInfo);
		
		Employee deletedEmployee = crudRepository.findById(8L).orElse(null);
		assertThat(deletedEmployee).isNull();
		
	}
	
	
	@Test
	@Order(4)
	void listEmployeeTest() {
		
		List<Employee> savedEmployee = crudRepository.findAll();
		System.out.println(savedEmployee);

		Assertions.assertThat(savedEmployee.isEmpty()).isFalse();
		
	}
}
