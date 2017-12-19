package com.my.sb.service;

import org.springframework.data.repository.CrudRepository;

import com.my.sb.model.Article;

public interface ArticleService extends CrudRepository<Article, Integer> {

}
