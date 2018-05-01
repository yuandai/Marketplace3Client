package com.market.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;



@Entity
@Table(name = "person")
public class Person implements java.io.Serializable {
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@Column(name = "name")
	private String name;
	@Column(name = "contact_info")
	private String contactInfo;
    @OneToMany
    @JoinColumn(name="owner_id", insertable=false, updatable=false, nullable=false)
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

	@Override
	public String toString() {
	        return new StringBuffer(" Name : ").append(this.name)
	                .append(" Contact Info : ").append(this.contactInfo).toString();
	}

}
