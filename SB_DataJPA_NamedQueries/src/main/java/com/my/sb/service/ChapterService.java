package com.my.sb.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.my.sb.model.Chapter;
import com.my.sb.model.Subject;
import com.my.sb.repository.ChapterRepository;

@Service
public class ChapterService  {

	@Autowired
	ChapterRepository repository;
	
	public List<Chapter> findByChNameIs(){
		return repository.findByChName();
	}

	/*public List<Subject> getAllSubjects() {
		return repository.getAllSubjects();
	}*/
}