package com.my.sb.predicatepkg;

import com.my.sb.model.QUser;
import com.mysema.query.types.Predicate;
import com.mysema.query.types.expr.NumberExpression;

final public class UserPredicates {

	public static Predicate hasNameAndSal(String name,Integer salary){
		return  QUser.user.name.eq(name).and(QUser.user.salary.eq(salary));
	}
	
	public static NumberExpression<Integer> maxSal(){
		return  QUser.user.salary.max();
	}

	public static Predicate findUserByAge(Integer age) {
		return QUser.user.age.eq(age);
	}

	public static Predicate findOneByAgeAndSal(Integer age, Integer sal) {
		QUser user = QUser.user;
		return user.age.eq(age).and(user.salary.eq(sal));
	}
}
