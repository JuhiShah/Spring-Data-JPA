package com.my.sb.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.my.sb.model.Article;

@Service
public class ArticleServiceImpl  {

	@Autowired
	ArticleService service;
	
	public List<Article> getAllArticles(){
		
		List<Article> articles = new ArrayList<Article>();
		service.findAll().forEach(articles::add);
		System.out.println("articles :: "+articles);
		return articles;
	}
	
	public Article getArticleById(int articleId){
		Article obj = service.findOne(articleId);
		//System.out.println("obj :: "+obj.getArticleId());
		return obj;
	}

	public void addArticle(Article article) {
		service.save(article);
	}

	public void updateArticle(Article article) {
		service.save(article);
		
	}

	public void deleteArticle(int id) {
		service.delete(id);
	}
	
}
