package com.my.sb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.my.sb.model.Chapter;
import com.my.sb.model.Subject;
import com.my.sb.service.ChapterService;
import com.my.sb.service.SubjectService;


@RestController
public class HomeController {

	@Autowired
	ChapterService service;
	
	@Autowired
	SubjectService serviceS;
	
	@GetMapping("basic")
	public List<Chapter> findChapterByName(){
		return service.findByChNameIs();
	}
	
	@GetMapping("allSubjects")
	public List<Subject> getAllSubjects(){
		return serviceS.getAllSubjects();
	}
	
}
