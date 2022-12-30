package com.example.javaexample.dto;

public class EmployeeDTO {
	
	private Long id;
	private String empName;
	private String department;
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
		return "EmployeeDTO [id=" + id + ", empName=" + empName + ", department=" + department + ", yearOfJoin="
				+ yearOfJoin + "]";
	}
	
}
