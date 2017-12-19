package com.my.sb.specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;

import com.my.sb.model.User;

public class UserSpecification {

	public static Specification<User> findsal(Integer sal) {
		return new Specification<User>() {
			@Override
			public Predicate toPredicate(Root<User> root, CriteriaQuery<?> cq, CriteriaBuilder cb) {
				return cb.gt(root.get("salary"),sal);
			}
		};
	}
	 
	public static Specification<User> findUser(Integer sal) {
		return new Specification<User>() {
			@Override
			public Predicate toPredicate(Root<User> root, CriteriaQuery<?> cq, CriteriaBuilder cb) {
				return cb.equal(root.get("salary"), sal);
			}
		};
	}
	
	public static Specification<User> findUserByCondtn(String name, Integer sal) {
		return new Specification<User>() {
			@Override
			public Predicate toPredicate(Root<User> root, CriteriaQuery<?> cq, CriteriaBuilder cb) {
				Predicate p1 = cb.equal(root.get("name"), name);
				Predicate p2 = cb.equal(root.get("salary"), sal);
				return cb.and(p1,p2);
			}
		};
	}
	
	public static Specification<User> findBysalAndOrderBy(Integer sal, boolean reqSorting, String colName, boolean descending ) {
		return new Specification<User>() {
			@Override
			public Predicate toPredicate(Root<User> root, CriteriaQuery<?> cq, CriteriaBuilder cb) {
				/*if( reqSorting && ( colName!= null && colName.trim().length() > 0 ) ){
					if(descending){
						cq.orderBy( cb.desc(root.get(colName.trim())) );
					}else{
						cq.orderBy( cb.asc(root.get(colName.trim())) );
					}
				}*/
				cq.orderBy( cb.desc(root.get(colName)) );
				return cb.gt(root.get("salary"),sal);
			}
		};
	}
}
