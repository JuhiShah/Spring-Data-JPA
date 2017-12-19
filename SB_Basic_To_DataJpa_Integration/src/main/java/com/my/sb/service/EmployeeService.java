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
	
	
	//---------------------------------------- QUERY METHODS ---------------------------------------------------------------------
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
    
    public List<Employee> findTopThreeByCode(String code){
    	return repository.findTop3ByCode(code);
    }
    
    public Employee findTopOneByCode(String code){
    	return repository.findTopOneByCode(code);
    }
    
    public List<Employee> findByAddressContainsOrCodeContainsAllIgnoreCase(String address, String empcode){
    	return repository.findByAddressContainsOrCodeContainsAllIgnoreCase(address, empcode);
    }
    
    
    //-------------------------------------------------- QUERY ANNOTATION --------------------------------------------------------
    public String findEmployeeByIdA(Integer id){
		String emp = repository.findEmployeeNameById(id);
		return emp;
	}

	public List<Employee> findEmployeesByNameA(String name) {
		return repository.findByName(name);
	}
}