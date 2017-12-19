package com.my.sb.repository;

import java.util.List;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.repository.Repository;

import com.my.sb.model.User;

public interface UserRepository extends Repository<User, Integer> {

	List<User> findAll(Specification<User> specification);
	User findOne(Specification<User> specification);
	
}