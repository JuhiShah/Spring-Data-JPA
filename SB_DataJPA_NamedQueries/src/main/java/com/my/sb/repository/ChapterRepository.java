package com.my.sb.repository;

import java.util.List;

import org.springframework.data.repository.Repository;

import com.my.sb.model.Chapter;

public interface ChapterRepository extends Repository<Chapter, Integer> {

	public List<Chapter> findByChName();
	
}