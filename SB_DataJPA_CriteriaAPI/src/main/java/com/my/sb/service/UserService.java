package com.my.sb.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.my.sb.model.User;
import com.my.sb.repository.UserRepository;
import com.my.sb.specification.UserSpecification;

@Service
public class UserService  {

	@Autowired
	UserRepository repository;
	
	public List<User> findGreaterSal(Integer sal){
		return repository.findAll(UserSpecification.findsal(sal));
	}

	public List<User> findUserBySal(Integer sal) {
		return repository.findAll(UserSpecification.findUser(sal));
	}
	
	public User findUser(String name, Integer sal) {
		return repository.findOne(UserSpecification.findUserByCondtn(name, sal));
	}
	
	public List<User> findGreaterWithOrderBy(Integer sal){
		//return repository.findByOrderBySalaryDesc(UserSpecification.findsal(sal));
		return repository.findAll(UserSpecification.findBysalAndOrderBy(sal, true, "age", true));
	}
	
}