package com.my.sb.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;
import org.springframework.data.repository.Repository;

import com.my.sb.model.User;
import com.mysema.query.types.Predicate;


public interface UserRepository extends Repository<User, Integer>, QueryDslPredicateExecutor<User> {

	
	// ----------------------- CRITERIA API------------------------------------------------
	List<User> findAll(Specification<User> specification);
	User findOne(Specification<User> specification);
	// ----------------------- QUERY DSL --------------------------------------------------
	List<User> findAll(Predicate predicate);
	List<User> findAll(Predicate predicate, Sort sort);
	//------------------------ DATA JPA PAGINATION -----------------------------------------
	Page<User> findAll(Pageable pageable);
	Page<User> findAllBySalary(Integer sal, Pageable pageable);
	
}