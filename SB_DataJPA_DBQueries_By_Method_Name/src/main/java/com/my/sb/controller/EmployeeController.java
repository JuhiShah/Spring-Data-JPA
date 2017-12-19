package com.my.sb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import com.my.sb.model.Employee;
import com.my.sb.service.EmployeeService;


@RestController
public class EmployeeController {

	@Autowired
	EmployeeService service;
	
	@GetMapping("emp/{id}")
	public Employee findById(@PathVariable Integer id){
		return service.findById(id);
	}
	
	@GetMapping("empobj/{name}/{code}")
    public List<Employee> findByNameOrCode(@PathVariable String name, @PathVariable String code){
    	return service.findByNameOrCode(name, code);
    }
    
	@GetMapping("count/{address}")
    public long countByAddress(@PathVariable String address){
		return service.countByAddress(address);
	}
    
	/*@GetMapping("distinct/{name}")
    public List<Employee> findDistinctByName(@PathVariable String name){
		return service.findDistinctByName(name);
	}*/
    
	@GetMapping("topmtost/{code}")
    public List<Employee> findTopOneByCode(@PathVariable String code){
    	return service.findTop3ByCode(code);
    }
    
	/*@GetMapping("orcase/{address}/{code}")
    List<Employee> findByAddressContainsOrCodeContainsAllIgnoreCase(@PathVariable String address, @PathVariable String empcode){
    	return service.findByAddressContainsOrCodeContainsAllIgnoreCase(address, empcode);
    }*/
}
