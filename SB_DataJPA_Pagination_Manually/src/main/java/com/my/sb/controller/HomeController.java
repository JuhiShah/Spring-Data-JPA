package com.my.sb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.my.sb.model.User;
import com.my.sb.service.UserService;


@RestController
public class HomeController {

	@Autowired
	UserService service;
	
	@RequestMapping("/getByPageNo/{pgno}")
	public Page<User> getByPageNo(@PathVariable("pgno") Integer pgno){
		System.out.println("controller");
		return service.getByPageNo(pgno);
	}
	
	@RequestMapping("/getByPageNo/{salary}/{sortingAttr}/{pgno}")
	public Page<User> getUserInDescBySalUsingPagination(@PathVariable("salary")Integer salary,
			@PathVariable("pgno")Integer pgno, @PathVariable("sortingAttr")String sortingParam){
		return service.getUserInDescBySalUsingPagination(salary,pgno,sortingParam);
	}
	

}
