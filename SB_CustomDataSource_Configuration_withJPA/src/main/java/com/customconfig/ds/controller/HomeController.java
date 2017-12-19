package com.customconfig.ds.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.customconfig.ds.model.User;
import com.customconfig.ds.service.UserService;


@RestController
public class HomeController {

	@Autowired
	UserService service;
	
	@GetMapping("/get")
	public List<User> findAll() {
		return service.findAll();
	}
}
