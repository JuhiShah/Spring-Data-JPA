package com.my.sb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.my.sb.model.Employee;
import com.my.sb.service.EmployeeService;


@RestController
public class EmployeeController {

	@Autowired
	EmployeeService service;
	
	//---------------------------------------- QUERY METHODS ---------------------------------------------------------------------
	
	@RequestMapping(value="emp/{id}")
	public Employee findById(@PathVariable Integer id){
		return service.findById(id);
	}
	
	@RequestMapping(value="empobj/{name}/{code}")
    public List<Employee> findByNameOrCode(@PathVariable String name, @PathVariable String code){
    	return service.findByNameOrCode(name, code);
    } 
    
	@RequestMapping(value="count/{address}")
    public long countByAddress(@PathVariable String address){
		return service.countByAddress(address);
	}
    
	//not working
	@RequestMapping(value="distinct/{name}")
    public List<Employee> findDistinctByName(@PathVariable String name){
		return service.findDistinctByName(name);
	}
    
	@RequestMapping(value="topmost/{code}")
    public List<Employee> findTopThreeByCode(@PathVariable String code){
    	return service.findTopThreeByCode(code);
    }
    
	@RequestMapping(value="topone/{code}")
    public Employee findTopOneByCode(@PathVariable String code){
    	return service.findTopOneByCode(code);
    }
	
	@RequestMapping(value="orcase/{address}/{code}")
    List<Employee> findByAddressContainsOrCodeContainsAllIgnoreCase(@PathVariable String address, @PathVariable String code){
    	return service.findByAddressContainsOrCodeContainsAllIgnoreCase(address, code);
    }
	
	//--------------------------- QUERY ANNOTATION------------------------------------------------------------------------------
	
	@RequestMapping(value="empA/{id}")
	public String findByIdA(@PathVariable Integer id){
		return service.findEmployeeByIdA(id);
	}
	
	@RequestMapping(value="empnameA/{name}")
	public List<Employee> findByNameA(@PathVariable String name){
		return service.findEmployeesByNameA(name);
	}
}
