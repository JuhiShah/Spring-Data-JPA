package com.customconfig.ds.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.customconfig.ds.model.User;
import com.customconfig.ds.repository.UserRepository;

@Service
public class UserService  {

	@Autowired
	UserRepository repository;
	
	@Transactional
	public List<User> findAll(){
		System.out.println("SERVICE");
		List<User> users = new ArrayList<User>();
		repository.findAll().forEach(users::add);
		System.out.println("users :: "+users);
		return users;
	}
}