// ----------------------- ADDING CUSTOM METHODS INTO A SINGLE REPOSITORY -----------------

package com.my.sb.repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.my.sb.model.SearchResult;

@Repository
public class UserRepositoryCustomImpl implements UserRepositoryCustom{

	private final NamedParameterJdbcTemplate jdbcTemplate;
	private String SEARCH_QUERY = "SELECT id,name from user where name= :searchTerm ORDER BY id desc";
	
	@Autowired
	UserRepositoryCustomImpl(NamedParameterJdbcTemplate jdbcTemplate){
		this.jdbcTemplate = jdbcTemplate;
	}
	
	@Transactional
	@Override
	public List<SearchResult> findBySearchTerm(String searchTerm) {
		Map<String, String> param = new HashMap<>();
		param.put("searchTerm", searchTerm);
		List<SearchResult> searchResults = jdbcTemplate.query(SEARCH_QUERY, param, new BeanPropertyRowMapper<>(SearchResult.class));
		return searchResults;
	}
}
