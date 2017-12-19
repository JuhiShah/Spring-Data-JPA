package com.my.sb.repository;

import java.util.List;

import com.my.sb.model.User;

public interface UserDAO {

	public List<User> userOrderBySalOS();
	public User userOrderBySalOSLimit();
	//Integer countBySalary(Integer salary);
}
