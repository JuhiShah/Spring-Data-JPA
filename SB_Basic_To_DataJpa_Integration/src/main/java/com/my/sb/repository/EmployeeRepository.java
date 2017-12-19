package com.my.sb.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;

import com.my.sb.model.Employee;


public interface EmployeeRepository extends Repository<Employee, Integer> {

	//Query methods
	public Employee findById(Integer id);
	
	public List<Employee> findByNameOrCode(String name, String code);
    
    public long countByAddress(String address);
    
    public List<Employee> findDistinctByName(String name);
  
    public List<Employee> findTop3ByCode(String code);
    
    public Employee findTopOneByCode(String code);
    
    List<Employee> findByAddressContainsOrCodeContainsAllIgnoreCase(String address, String empcode);
  
    
    //Query annotation
    @Query("select name from Employee where id = :id")
	String findEmployeeNameById(@Param("id") Integer id);

	@Query(value="select emp.* from Employee emp where emp.name= ?1",nativeQuery=true)
	List<Employee> findByName(String name);
    
    
}

