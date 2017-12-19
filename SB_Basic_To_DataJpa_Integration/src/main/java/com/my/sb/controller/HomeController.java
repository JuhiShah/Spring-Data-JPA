package com.my.sb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.my.sb.model.Article;
import com.my.sb.model.Chapter;
import com.my.sb.model.SearchResult;
import com.my.sb.model.Subject;
import com.my.sb.model.User;
import com.my.sb.service.ArticleServiceImpl;
import com.my.sb.service.ChapterService;
import com.my.sb.service.SubjectService;
import com.my.sb.service.UserService;

@RestController
public class HomeController {

	@Autowired
	ArticleServiceImpl articleService;
	
	@Autowired
	ChapterService chapterService;
	
	@Autowired
	SubjectService subjectService;
	
	@Autowired
	UserService userService;
	
	
	// --------------------------- SIMPLE REQUEST --------------------------------------------------
	
	@RequestMapping("/home")
	public String hello(){
		return "Hello World !";
	}
	
	// -------------------- SPRING BOOT REST API(@RestController) WITH STATIC DATA  (WITHOUT DB INTEGRATION) -----------
	
	@RequestMapping(value="articles")
	public List<Article> getAllArticles() {
		System.out.println("getAllArticles");
		return articleService.getAllArticles();
	}
	
	@RequestMapping(value="articles/{id}")
	public Article getArticleById(@PathVariable("id") Integer id) {
		return articleService.getArticleById(id);
	}
	
	@RequestMapping(value="articles", method = RequestMethod.POST)
	public void addArticle(@RequestBody Article article){
		articleService.addArticle(article);
		System.out.println("added");
	}
	
	@RequestMapping(value= "articles/{id}", method=RequestMethod.PUT)
	public void updateArticle(@RequestBody Article article, @PathVariable int id){
		articleService.updateArticle(article,id);
	}
	
	@RequestMapping(value= "articles/{id}", method=RequestMethod.DELETE)
	public void deleteArticle(@PathVariable int id){
		articleService.deleteArticle(id);
	}
	
	// ----------------- FOR NAMED AND NATIVE NAMED QUERY ANNOTATION ----------------------------------------------
	
	@RequestMapping(value= "basic")
	public List<Chapter> findChapterByName(){
		return chapterService.findByChNameIs();
	}
	
	@RequestMapping(value= "allSubjects")
	public List<Subject> getAllSubjects(){
		return subjectService.getAllSubjects();
	}
	
	
	// ----------------- FOR CRITERIA API IN DATA JPA ----------------------------------------------------------------
	
	@RequestMapping(value= "/salgt/{salary}")
	public List<User> greaterSalThan(@PathVariable("salary") Integer sal){
		return userService.findGreaterSal(sal);
	}
	
	@RequestMapping(value= "/findUserBySal/{salary}")
	public List<User> findUserBySal(@PathVariable("salary") Integer sal){
		return userService.findUserBySal(sal);
	}
	
	@RequestMapping(value= "/findUserByNameAndSal/{name}/{salary}")
	public User findUserByNameAndSal(@PathVariable("salary") Integer sal, @PathVariable("name") String name){
		return userService.findUser(name, sal);
	}
	
	@RequestMapping(value= "/gtWithOrderBy/{salary}")
	public List<User> gtWithOrderBy(@PathVariable("salary") Integer sal){
		return userService.findGreaterWithOrderBy(sal);
	}
	
	
	// ----------------- FOR QUERYDSL IN DATA JPA------------------------------------------------------------------
	
	@RequestMapping("/findUserByNameAndSalQdsl/{name}/{salary}")
	public List<User> findUserBySal(@PathVariable("salary") Integer sal, @PathVariable("name") String name){
		return userService.findUserBySal(name, sal);
	}
	
	@RequestMapping("/findUserByAge/{age}")
	public List<User> findUserByAge(@PathVariable("age") Integer age){
		return userService.findUserByAge(age);
	}
	
	@RequestMapping("/findUserByAgeAndSalDesc/{age}/{salary}")
	public List<User> findUserByAgeAndSalDesc(@PathVariable("age") Integer age, @PathVariable("salary") Integer sal){
		return userService.findUserByAgeAndSalDesc(age,sal);
	}
	
	@RequestMapping("/userOrderBySalOS")
	public List<User> userOrderBySalOS(){
		return userService.userOrderBySalOS();
	}
	
	@RequestMapping("/userOrderBySalOSLimit")
	public User userOrderBySalOSLimit(){
		return userService.userOrderBySalOSLimit();
	}
	
	//---------------------------------- DATA JPA PAGINATION -----------------------------------------------------------
	
	@RequestMapping("/getByPageNo/{pgno}")
	public Page<User> getByPageNo(@PathVariable("pgno") Integer pgno){
		System.out.println("controller");
		return userService.getByPageNo(pgno);
	}
	
	@RequestMapping("/getByPageNo/{salary}/{sortingAttr}/{pgno}")
	public Page<User> getUserInDescBySalUsingPagination(@PathVariable("salary")Integer salary,
			@PathVariable("pgno")Integer pgno, @PathVariable("sortingAttr")String sortingParam){
		return userService.getUserInDescBySalUsingPagination(salary,pgno,sortingParam);
	}
	
	// ----------------------- ADDING CUSTOM METHODS INTO A SINGLE REPOSITORY -------------------------------------------
	
	@RequestMapping("/findBySearchTerm/{name}")
	public List<SearchResult> findBySearchTerm(@PathVariable("name") String searchTerm) {
		return userService.findBySearchTerm(searchTerm);
	}
}
