package com.my.sb.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.my.sb.model.Topic;
import com.my.sb.repository.TopicService;

@Service
public class TopicServiceImpl  {

	@Autowired
	TopicService service;
	
	public List<Topic> getAllTopics(){
		
		List<Topic> topics = new ArrayList<Topic>();
		service.findAll().forEach(topics::add);
		System.out.println("topics :: "+topics);
		return topics;
	}
	
	public Topic getTopicById(int topicId){
		Topic obj = service.findOne(topicId);
		//System.out.println("obj :: "+obj.getTopicId());
		return obj;
	}

	public void addTopic(Topic topic) {
		service.save(topic);
	}

	public void updateTopic(Topic topic) {
		service.save(topic);
	}

	public void deleteTopic(int id) {
		service.delete(id);
	}
}