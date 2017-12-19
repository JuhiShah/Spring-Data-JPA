package com.my.sb.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.Repository;

import com.my.sb.model.User;


public interface UserRepository extends Repository<User, Integer>, PagingAndSortingRepository<User,Integer> {

	Page<User> findAllBySalary(Integer sal, Pageable pageable);
	
}