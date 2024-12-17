package com.example.demo.Model;

import java.util.List;

public class Question {
	private String id;
	private String desc;
	private List<String> options;
	private String correctans;
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
	public List<String> getOptions() {
		return options;
	}
	public void setOptions(List<String> options) {
		this.options = options;
	}
	public String getCorrectans() {
		return correctans;
	}
	public void setCorrectans(String correctans) {
		this.correctans = correctans;
	}
	public Question(String id, String desc, List<String> options, String correctans) {
		
		this.id = id;
		this.desc = desc;
		this.options = options;
		this.correctans = correctans;
	}
	public Question() {
		
		
	}
	@Override
	public String toString() {
		return "Question [id=" + id + ", desc=" + desc + ", options=" + options + ", correctans=" + correctans + "]";
	}
	
	
	
}
