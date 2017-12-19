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
	public String findById(@PathVariable Integer id){
		return service.findEmployeeById(id);
	}
	
	@GetMapping("empname/{name}")
	public List<Employee> findByName(@PathVariable String name){
		return service.findEmployeesByName(name);
	}
	
}
