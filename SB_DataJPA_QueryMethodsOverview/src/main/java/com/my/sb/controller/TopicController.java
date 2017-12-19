package com.my.sb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.my.sb.model.Topic;
import com.my.sb.service.TopicServiceImpl;

@RestController
public class TopicController {

	@Autowired
	TopicServiceImpl topicService;
	
	
	@GetMapping("topic/{id}")
	public Topic getTopicById(@PathVariable("id") Integer id) {
		return topicService.getTopicById(id);
	}
	
	@GetMapping("topics/{id}")
	public String findTopicNameById(@PathVariable("id") Integer id) {
		return topicService.findTopicTitleById(id);
	}
	
	@GetMapping("findbyname/{name}")
	public List<Topic> findAllTopicByName(@PathVariable("name") String name) {
		return topicService.findAllTopicByName(name);
	}
}
