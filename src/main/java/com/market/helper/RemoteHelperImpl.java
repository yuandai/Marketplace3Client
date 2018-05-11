package com.market.helper;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;

import com.market.model.Bid;
import com.market.model.Person;
import com.market.model.Project;
import com.market.transfer.BidsDTO;
import com.market.transfer.ProjectBidsDTO;
import com.market.transfer.ProjectsDTO;

public class RemoteHelperImpl implements RemoteHelper {
	
	@Autowired
	protected RestTemplate restTemplate;
	
	protected String serviceUrl;
	
	public RemoteHelperImpl(String serviceUrl) {
		this.serviceUrl = serviceUrl.startsWith("http") ? serviceUrl
				: "http://" + serviceUrl;
	}
	
	public void initial() {
		
		restTemplate.postForObject(serviceUrl+"/MarketPlace/rest/service/initial", new String(), String.class);
		return;
		
	}
	
	public void assign() {
		
		restTemplate.postForObject(serviceUrl+"/MarketPlace/rest/service/assign", new String(), String.class);
		return;
		
	}


	/*
	 * Bid Helper
	 */
	
	public BidsDTO getBidsOfPerson(String name) {
		
		BidsDTO ret = restTemplate.getForObject(serviceUrl+"/MarketPlace/rest/service/bidsByPerson?name=" + name, BidsDTO.class);
		
		return ret;
	}
	
	
	public boolean createBid(Bid bid) {
		
		restTemplate.postForObject(serviceUrl+"/MarketPlace/rest/service/bids", bid, String.class);
		
		return true;
	}

	
	
	public boolean updateBid(Bid bid) {
		
		restTemplate.put(serviceUrl+"/MarketPlace/rest/service/bids", bid);
		
		return true;
	}
	
	
	/*
	 * Project Helper
	 */
	
	public boolean updateProject(Project project) {
		
		restTemplate.put(serviceUrl+"/MarketPlace/rest/service/projects", project);
		
		return true;
		
	}
	
	public ProjectsDTO getProjectsOfPerson(String name) {
		
		ProjectsDTO ret = restTemplate.getForObject(serviceUrl+"/MarketPlace/rest/service/projects?name=" + name, ProjectsDTO.class);
		
		return ret;
	}

	
	public boolean createProject(Project project) {
		
		restTemplate.postForObject(serviceUrl+"/MarketPlace/rest/service/projects", project, String.class);
		return true;
		
	}
	
	public ProjectBidsDTO getProjectWithAllBids(String projectName) {
				
		ProjectBidsDTO ret = restTemplate.getForObject(serviceUrl+"/MarketPlace/rest/service/bidsByProject?projectName=" + projectName, ProjectBidsDTO.class);
		return ret;
	}
	
	
	/*
	 * Person Helper
	 */
	
	public boolean createPerson(Person person) {
		
		restTemplate.postForObject(serviceUrl+"/MarketPlace/rest/service/persons", person, String.class);
		return true;
	}
	
	
	
}

