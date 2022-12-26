package com.example.javaexample.dto;

public class EmployeeDTO {
	
	private Long id;
	private String empName;
	private String department;
	
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
	
	@Override
	public String toString() {
		return "EmployeeDTO [id=" + id + ", empName=" + empName + ", department=" + department + "]";
	}

	
	
}
