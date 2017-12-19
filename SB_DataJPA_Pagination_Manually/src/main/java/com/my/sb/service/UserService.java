package com.my.sb.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.my.sb.model.User;
import com.my.sb.repository.UserRepository;
import com.my.sb.utility.PaginationUtility;

@Service
public class UserService  {

	@Autowired
	UserRepository repository;
	
	public Page<User> getByPageNo(Integer pgno) {
		System.out.println("before call");
		return  repository.findAll(new PageRequest(pgno, 2)) ;
	}

	public Page<User> getUserInDescBySalUsingPagination(Integer salary, Integer pgno, String sortingParam) {
		Pageable pageable = PaginationUtility.getPageableObj(pgno,sortingParam);
		return repository.findAllBySalary(salary, pageable);
	}
}