package com.my.sb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.my.sb.model.User;
import com.my.sb.service.UserService;


@RestController
public class HomeController {

	@Autowired
	UserService service;
	
	@GetMapping("salgt/{salary}")
	public List<User> greaterSalThan(@PathVariable("salary") Integer sal){
		return service.findGreaterSal(sal);
	}
	
	@GetMapping("/findUserBySal/{salary}")
	public List<User> findUserBySal(@PathVariable("salary") Integer sal){
		return service.findUserBySal(sal);
	}
	
	@GetMapping("/findUserBySal/{name}/{salary}")
	public User findUser(@PathVariable("salary") Integer sal, @PathVariable("name") String name){
		return service.findUser(name, sal);
	}
	
	@GetMapping("/gtWithOrderBy/{salary}")
	public List<User> gtWithOrderBy(@PathVariable("salary") Integer sal){
		return service.findGreaterWithOrderBy(sal);
	}
}
