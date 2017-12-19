package com.my.sb.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.my.sb.model.Chapter;
import com.my.sb.model.Subject;
import com.my.sb.repository.ChapterRepository;
import com.my.sb.repository.SubjectRepository;

@Service
public class SubjectService  {

	@Autowired
	SubjectRepository repository;
	
	public List<Subject> getAllSubjects() {
		return repository.findAllSub();
	}
}