package com.my.sb.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.my.sb.model.Topic;
import com.my.sb.repository.TopicService;

@Service
public class TopicServiceImpl  {

	@Autowired
	TopicService service;
	
	public Topic getTopicById(int topicId){
		Topic topic = service.findById(topicId);
		System.out.println("topic :: "+topic);
		if(topic == null){
			System.out.println("topic is null");
			return null;
		}
		return topic;
		
	}

	public String findTopicTitleById(int id){
		String title = service.findTopicNameById(id);
		System.out.println("title :: "+title);
		return title;
	}
	
	public List<Topic> findAllTopicByName(String name) {
		List<Topic> topics = service.findAllByName(name);
		if(topics.size() > 0){
			return topics;
		}else{
			System.out.println("No topic found");
			return null;
		}
	}
}