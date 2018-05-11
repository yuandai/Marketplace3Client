package com.market.helper;

import com.market.model.Bid;
import com.market.model.Person;
import com.market.model.Project;
import com.market.transfer.BidsDTO;
import com.market.transfer.ProjectBidsDTO;
import com.market.transfer.ProjectsDTO;

public interface RemoteHelper {
	
	
	public void initial();
	
	public void assign();

	/*
	 * Bid Helper
	 */
	
	public BidsDTO getBidsOfPerson(String name);
		
	public boolean createBid(Bid bid);
	
	public boolean updateBid(Bid bid);
	
	
	/*
	 * Project Helper
	 */
	
	public boolean updateProject(Project project);
	
	public ProjectsDTO getProjectsOfPerson(String name);

	public boolean createProject(Project project);
	
	public ProjectBidsDTO getProjectWithAllBids(String projectName);
	
	
	/*
	 * Person Helper
	 */
	
	public boolean createPerson(Person person);

}
