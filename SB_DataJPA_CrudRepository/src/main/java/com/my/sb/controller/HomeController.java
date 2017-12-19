package com.my.sb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.my.sb.model.Article;
import com.my.sb.service.ArticleServiceImpl;

@RestController
public class HomeController {

	@Autowired
	ArticleServiceImpl articleService;
	
	@GetMapping("articles")
	public List<Article> getAllArticles() {
		System.out.println("getAllArticles");
		return articleService.getAllArticles();
	}
	
	@GetMapping("articles/{id}")
	public Article getArticleById(@PathVariable("id") Integer id) {
		return articleService.getArticleById(id);
	}
	
	@PostMapping("articles")
	public void addArticle(@RequestBody Article article){
		articleService.addArticle(article);
		System.out.println("added");
	}
	
	@PutMapping("articles")
	public void updateArticle(@RequestBody Article article){
		articleService.updateArticle(article);
	}
	
	@DeleteMapping("articles/{id}")
	public void deleteArticle(@PathVariable int id){
		articleService.deleteArticle(id);
	}
	
}
