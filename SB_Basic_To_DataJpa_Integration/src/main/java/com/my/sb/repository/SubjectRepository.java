package com.my.sb.repository;

import java.util.List;

import org.springframework.data.repository.Repository;

import com.my.sb.model.Subject;

public interface SubjectRepository extends Repository<Subject, Integer> {

	public List<Subject> findAllSub();
}