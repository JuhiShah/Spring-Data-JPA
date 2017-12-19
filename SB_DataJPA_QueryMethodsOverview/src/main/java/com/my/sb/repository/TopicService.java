package com.my.sb.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;

import com.my.sb.model.Topic;

public interface TopicService  extends Repository<Topic, Integer> {

	
	@Query("select t.name from Topic t where t.id = :id")
	String findTopicNameById(@Param("id") Integer id);
	
	Topic findById(Integer id);
	List<Topic> findAllByName(String name);
	
}

