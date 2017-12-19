package com.my.sb.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.my.sb.model.Employee;
import com.my.sb.repository.EmployeeRepository;

@Service
public class EmployeeService  {

	@Autowired
	EmployeeRepository repository;
	
	public Employee findById(Integer id){
		Employee emp =	repository.findById(id);
		return emp;
	}
	
	public List<Employee> findByNameOrCode(String name, String code){
		List<Employee> emplist = repository.findByNameOrCode(name, code);
		return emplist;
	}
    
    
    public long countByAddress(String address){
    	return repository.countByAddress(address);
    	
    }
    
    public List<Employee> findDistinctByName(String name){
    	return repository.findDistinctByName(name);
    }
    
    public List<Employee> findTop3ByCode(String code){
    	return repository.findTop3ByCodeOrderByNameAsc(code);
    }
    
    public List<Employee> findByAddressContainsOrCodeContainsAllIgnoreCase(String address, String empcode){
    	return repository.findByAddressContainsOrCodeContainsAllIgnoreCase(address, empcode);
    }
}