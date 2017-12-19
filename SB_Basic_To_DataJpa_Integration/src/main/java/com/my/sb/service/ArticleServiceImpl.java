package com.my.sb.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.my.sb.model.Article;

@Service
public class ArticleServiceImpl  {

	private List<Article> articles =  new ArrayList<>(Arrays.asList(
			new Article(1, "article_1", "category_1"),
			new Article(2, "article_2", "category_2"),
			new Article(3, "article_3", "category_3")
			));

	
	public List<Article> getAllArticles(){
		System.out.println("articles :: "+articles);
		return articles;
	}
	
	public Article getArticleById(int articleId) {
		Article obj = articles.stream().filter(a -> a.getArticleId() == articleId).findFirst().get();
		System.out.println("obj :: "+obj);
		return obj;
	}

	public void addArticle(Article article) {
		articles.add(article);
	}

	public void updateArticle(Article article, int id) {
		for(int i=0; i<articles.size(); i++){
			Article a = articles.get(i);
			if(a.getArticleId()==id){
				articles.set(i, article);
			}
		}
		
	}

	public void deleteArticle(int id) {
		articles.removeIf(a->a.getArticleId() == id);
	}

}
