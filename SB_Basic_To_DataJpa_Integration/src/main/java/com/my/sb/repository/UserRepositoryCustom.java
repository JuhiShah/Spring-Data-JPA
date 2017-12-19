package com.my.sb.repository;

import java.util.List;

import com.my.sb.model.SearchResult;


public interface UserRepositoryCustom {

	// ----------------------- ADDING CUSTOM METHODS INTO A SINGLE REPOSITORY -----------------
	List<SearchResult> findBySearchTerm(String searchTerm);
}