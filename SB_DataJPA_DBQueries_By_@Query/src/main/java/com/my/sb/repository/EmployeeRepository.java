package com.my.sb.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;

import com.my.sb.model.Employee;


public interface EmployeeRepository extends Repository<Employee, Integer> {

	
	//Using JPQL
	//@Param is used for named parameter
	@Query("select emp.name from Employee emp where emp.id = :id")
	String findEmployeeNameById(@Param("id") Integer id);

	//Using SQL
	@Query(value="select emp.* from Employee emp where emp.name= ?",nativeQuery=true)
	List<Employee> findByName(String name);
    
}