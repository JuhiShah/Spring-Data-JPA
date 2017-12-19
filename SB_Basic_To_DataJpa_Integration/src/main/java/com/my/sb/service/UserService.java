package com.my.sb.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.my.sb.model.SearchResult;
import com.my.sb.model.User;
import com.my.sb.predicatepkg.UserPredicates;
import com.my.sb.repository.UserDAO;
import com.my.sb.repository.UserRepository;
import com.my.sb.repository.UserRepositoryCustom;
import com.my.sb.specification.UserSpecification;
import com.my.sb.utility.PaginationUtility;

@Service
public class UserService  {

	@Autowired
	UserRepository repository;
	
	@Autowired
	UserRepositoryCustom customRepository;
	
	@Autowired
	UserDAO dao;
	
	
	// ----------------- FOR CRITERIA API IN DATA JPA ----------------------------------------------------------------
	
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
		return repository.findAll(UserSpecification.findBysalAndOrderBy(sal, true, "age", true));
	}
	
	
	// ----------------- FOR QUERYDSL IN DATA JPA------------------------------------------------------------------
	
	public List<User> findUserBySal(String name, Integer sal) {
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
	
	//---------------------------------- DATA JPA PAGINATION -----------------------------------------------------------
	
	public Page<User> getByPageNo(Integer pgno) {
		System.out.println("before call");
		return  repository.findAll(new PageRequest(pgno, 2)) ;
	}

	public Page<User> getUserInDescBySalUsingPagination(Integer salary, Integer pgno, String sortingParam) {
		Pageable pageable = PaginationUtility.getPageableObj(pgno,sortingParam);
		return repository.findAllBySalary(salary, pageable);
	}
	
	
	// ----------------------- ADDING CUSTOM METHODS INTO A SINGLE REPOSITORY -------------------------------------------
	
	public List<SearchResult> findBySearchTerm(String searchTerm) {
		return customRepository.findBySearchTerm(searchTerm);
	}

}