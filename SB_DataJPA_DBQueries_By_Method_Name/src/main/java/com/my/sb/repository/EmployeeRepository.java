package com.my.sb.repository;

import java.util.List;
import org.springframework.data.repository.Repository;
import com.my.sb.model.Employee;


public interface EmployeeRepository extends Repository<Employee, Integer> {

	//finds employee obj from search criteria as id(or by id) as method name suggests
	public Employee findById(Integer id);
	
	
    public List<Employee> findByNameOrCode(String name, String code);
    
    
    public long countByAddress(String address);
    
    //locho
    public List<Employee> findDistinctByName(String name);
    
    /**//**
     * Returns the first three todo entries whose title is given
     * as a method parameter. If no todo entries is found, this
     * method returns an empty list.
     *//*
*/   public List<Employee> findTop3ByCodeOrderByNameAsc(String code);
    //public List<Employee> findTop3ByCode(String code);
    
    List<Employee> findByAddressContainsOrCodeContainsAllIgnoreCase(String address, String empcode);
    
    
}

