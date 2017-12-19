package com.my.sb.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;



@Entity
@Table(name="chapter")
@NamedQuery(name="Chapter.findByChName", query="SELECT chapter FROM Chapter chapter WHERE chapter.chName = 'c21'")
public class Chapter {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="chid")
	private Integer chId;
	
	@Column(name="chname")
	private String chName;
	
	@Column(name="chdescription")
	private String chDescription;
	
	@ManyToOne
	@JoinColumn(name="subject")
	private Subject subject;
	
	public Integer getChId() {
		return chId;
	}
	public void setChId(Integer chId) {
		this.chId = chId;
	}
	public String getChName() {
		return chName;
	}
	public void setChName(String chName) {
		this.chName = chName;
	}
	
	public String getChDescription() {
		return chDescription;
	}
	public void setChDescription(String chDescription) {
		this.chDescription = chDescription;
	}
	
	public Subject getSubject() {
		return subject;
	}
	public void setSubject(Subject subject) {
		this.subject = subject;
	}
}
