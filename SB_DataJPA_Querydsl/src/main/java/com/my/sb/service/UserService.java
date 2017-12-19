package com.my.sb.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.my.sb.model.User;
import com.my.sb.predicatepkg.UserPredicates;
import com.my.sb.repository.UserDAO;
import com.my.sb.repository.UserRepository;

@Service
public class UserService  {

	@Autowired
	UserRepository repository;
	
	@Autowired
	UserDAO dao;
	
	public List<User> findUser(String name, Integer sal) {
		return repository.findAll(UserPredicates.hasNameAndSal(name, sal));
	}

	public List<User> findUserByAge(Integer age) {
		return repository.findAll(UserPredicates.findUserByAge(age));
	}

	public List<User> findUserByAgeAndSalDesc(Integer age, Integer sal) {
		return repository.findAll(UserPredicates.findOneByAgeAndSal(age,sal), new Sort(Sort.Direction.DESC, "name"));
	}

	public List<User> userOrderBySalOS() {
		return dao.userOrderBySalOS();
	}

	public User userOrderBySalOSLimit() {
		return dao.userOrderBySalOSLimit();
	}
}