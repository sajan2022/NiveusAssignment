package com.example.javaexample.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.javaexample.entity.Employee;

@Repository
public interface CrudRepository extends JpaRepository<Employee, Long>{

	
}
