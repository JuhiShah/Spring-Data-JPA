package com.my.sb.repository;

import java.util.List;
import org.springframework.data.domain.Sort;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;
import org.springframework.data.repository.Repository;
import com.my.sb.model.User;
import com.mysema.query.types.Predicate;

public interface UserRepository extends Repository<User, Integer>, QueryDslPredicateExecutor<User> {

	List<User> findAll(Predicate predicate);
	List<User> findAll(Predicate predicate, Sort sort);

}