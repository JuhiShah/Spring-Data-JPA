package com.my.sb.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name="article")
public class Article {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
    private int id;  
	private String title;
	private String category;
	
	
	public Article() {
		
	}
	
	/*public Article(int articleId1, String title, String category) {
		super();
		this.id = articleId;
		this.title = title;
		this.category = category;
	}*/
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public String getTitle() {
		return title;
	}
	

	

	public void setTitle(String title) {
		this.title = title;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
}
