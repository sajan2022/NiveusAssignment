package com.example.javaexample.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.javaexample.entity.Employee;

public interface CrudRepository extends JpaRepository<Employee, Long>{

	
}
