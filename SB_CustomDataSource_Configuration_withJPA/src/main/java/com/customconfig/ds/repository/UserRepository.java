package com.customconfig.ds.repository;

import org.springframework.data.repository.CrudRepository;

import com.customconfig.ds.model.User;

public interface UserRepository extends CrudRepository<User, Integer> {

}