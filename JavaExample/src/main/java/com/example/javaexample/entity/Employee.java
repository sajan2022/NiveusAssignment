package com.example.javaexample.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "employee")
public class Employee {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "emp_id")
	private Long id;
	
	@Column(name = "emp_name")
	private String empName;
	
	@Column(name = "department")
	private String department;
	
	@Column(name = "year_of_join")
	private String yearOfJoin;

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}

	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	
	public String getYearOfJoin() {
		return yearOfJoin;
	}
	public void setYearOfJoin(String yearOfJoin) {
		this.yearOfJoin = yearOfJoin;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", empName=" + empName + ", department=" + department + ", yearOfJoin="
				+ yearOfJoin + "]";
	}
	
}
