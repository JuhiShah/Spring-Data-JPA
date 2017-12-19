package com.my.sb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.my.sb.model.Topic;
import com.my.sb.service.TopicServiceImpl;

@RestController
public class TopicController {


	@Autowired
	TopicServiceImpl topicService;
	
	// ---------- DB INTEGRATION AND CRUD OPERATION USING CRUD REPOSITORY
	
	@RequestMapping(value= "topics")
	public List<Topic> getAllTopics() {
		System.out.println("getAllTopics");
		return topicService.getAllTopics();
	}
	
	@RequestMapping(value= "topics/{id}")
	public Topic getTopicById(@PathVariable("id") Integer id) {
		return topicService.getTopicById(id);
	}
	
	@RequestMapping(value= "topics", method=RequestMethod.POST)
	public void addTopic(@RequestBody Topic topic){
		topicService.addTopic(topic);
		System.out.println("added");
	}
	
	@RequestMapping(value= "topics", method=RequestMethod.PUT)
	public void updateTopic(@RequestBody Topic topic){
		topicService.updateTopic(topic);
	}
	
	@RequestMapping(value= "topics/{id}", method=RequestMethod.DELETE)
	public void deleteTopic(@PathVariable int id){
		topicService.deleteTopic(id);
	}
	
}
