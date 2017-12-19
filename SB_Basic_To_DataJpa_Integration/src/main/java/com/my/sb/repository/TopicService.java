package com.my.sb.repository;

import org.springframework.data.repository.CrudRepository;

import com.my.sb.model.Topic;

public interface TopicService  extends CrudRepository<Topic, Integer> {

}

