package com.market.model;

import java.util.HashSet;
import java.util.Set;




public class Person  {
	
	private static final long serialVersionUID = 1L;
	private int id;
	private String name;
	private String contactInfo;
    private Set<Project> projects = new HashSet<Project>();
	
	public Person() {
		
	}
	
	public Person(String name, String contactInfo) {
		this.name = name;
		this.contactInfo = contactInfo;
	}
	
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return this.name;
	}
	
	public void setContactInfo(String contactInfo) {
		this.contactInfo = contactInfo;
	}
	
	public String getContactInfo() {
		return this.contactInfo;
	}
	
	public Set<Project> getProjects() {
		return projects;
	}

	public void setProjects(Set<Project> projects) {
		this.projects = projects;
	}


}
