package com.my.sb.repository;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import com.my.sb.model.QUser;
import com.my.sb.model.User;
import com.mysema.query.jpa.impl.JPAQuery;
import com.mysema.query.types.OrderSpecifier;

@Repository
public class UserDAOImpl implements UserDAO{

	@PersistenceContext
	EntityManager em;
	
	@Override
	public List<User> userOrderBySalOS() {
		
		JPAQuery jpaQuery = new JPAQuery(em);
		OrderSpecifier<Integer> orderSpecifier = QUser.user.salary.desc();
		List<User> list = jpaQuery.from(QUser.user).orderBy(orderSpecifier).list(QUser.user);
		return list;
	}

	@Override
	public User userOrderBySalOSLimit() {
		
		JPAQuery jpaQuery = new JPAQuery(em);
		OrderSpecifier<Integer> orderSpecifier = QUser.user.salary.desc();
		List<User> list = jpaQuery.from(QUser.user).orderBy(orderSpecifier).limit(1).list(QUser.user);
		return list.get(0);
	}
}
