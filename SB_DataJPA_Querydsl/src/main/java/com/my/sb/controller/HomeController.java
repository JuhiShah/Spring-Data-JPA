package com.my.sb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.my.sb.model.User;
import com.my.sb.service.UserService;


@RestController
public class HomeController {

	@Autowired
	UserService service;
	
	@RequestMapping("/findUserBySal/{name}/{salary}")
	public List<User> findUser(@PathVariable("salary") Integer sal, @PathVariable("name") String name){
		return service.findUser(name, sal);
	}
	
	@RequestMapping("/findUserByAge/{age}")
	public List<User> findUserByAge(@PathVariable("age") Integer age){
		return service.findUserByAge(age);
	}
	
	@RequestMapping("/findUserByAgeAndSalDesc/{age}/{salary}")
	public List<User> findUserByAgeAndSalDesc(@PathVariable("age") Integer age, @PathVariable("salary") Integer sal){
		return service.findUserByAgeAndSalDesc(age,sal);
	}
	
	@RequestMapping("/userOrderBySalOS")
	public List<User> userOrderBySalOS(){
		return service.userOrderBySalOS();
	}
	
	@RequestMapping("/userOrderBySalOSLimit")
	public User userOrderBySalOSLimit(){
		return service.userOrderBySalOSLimit();
	}
}
