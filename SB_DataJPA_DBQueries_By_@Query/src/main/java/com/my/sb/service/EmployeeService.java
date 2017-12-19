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
	
	public String findEmployeeById(Integer id){
		String emp = repository.findEmployeeNameById(id);
		return emp;
	}

	public List<Employee> findEmployeesByName(String name) {
		return repository.findByName(name);
	}
}