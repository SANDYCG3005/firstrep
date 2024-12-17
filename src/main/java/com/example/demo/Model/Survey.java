package com.example.demo.Model;

import java.util.List;

public class Survey {
	private String id;
	private String desc;
	private String title;
	private List<Question> questions;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public List<Question> getQuestions() {
		return questions;
	}
	public void setQuestions(List<Question> questions) {
		this.questions = questions;
	}
	public Survey(String id, String desc, String title, List<Question> questions) {
		
		this.id = id;
		this.desc = desc;
		this.title = title;
		this.questions = questions;
	}
	public Survey() {
		
	}
	@Override
	public String toString() {
		return "Survey [id=" + id + ", desc=" + desc + ", title=" + title + ", questions=" + questions + "]";
	}
	
	

}
