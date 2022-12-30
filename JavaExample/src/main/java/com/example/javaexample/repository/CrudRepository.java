package com.example.javaexample.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.javaexample.entity.Employee;

@Repository
public interface CrudRepository extends JpaRepository<Employee, Long>{

	@Query("SELECT e FROM Employee e WHERE LOWER(e.empName) LIKE LOWER(CONCAT('%',:value,'%')) ")
	List<Employee> findByName(@Param("value")String value);
	
	@Query("SELECT e FROM Employee e WHERE LOWER(e.department) LIKE LOWER(CONCAT('%',:value,'%')) ")
	List<Employee> findByDepartment(@Param("value")String value);
}
