package com.market.helper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.market.model.Bid;
import com.market.model.Database;
import com.market.model.Person;
import com.market.model.Project;
import com.market.transfer.ProjectBidsDTO;
import com.market.transfer.ProjectsDTO;
import com.market.validation.Validation;

/*
 * Business Object
 */

@Service
@Transactional
public class ProjectHelper {
	
	@Autowired
	Database database;
	@Autowired
	Validation validation;
	
	@Autowired
	public void setDatabase(Database database) {
		this.database = database;
	}
	
	@Autowired
	public void setValidation(Validation validation) {
		this.validation = validation;
	}
	
	public boolean updateProject(Project project) {
		boolean result = false;
		
		if (validation.validateUpdateProject(project)) {
			
			database.saveProject(project);
			result = true;
			
		} else
			
			result = false;
		
		return result;
		
	}
	
	
	public ProjectsDTO getProjectsOfPerson(String name) {
		
		ProjectsDTO ret = new ProjectsDTO();
		
		List<Project> projs = database.getProjectsByOwnerName(name);
		
		ret = new ProjectsDTO(projs);
		
		return ret;
	}

	
	public boolean createProject(Project project) {
		boolean result = false;
		
		if (validation.validateCreateProject(project)) {
			
			database.saveProject(project);
			result = true;
			
		} else
			
			result = false;
		
		return result;
		
	}
	
	public ProjectBidsDTO getProjectWithAllBids(String projectName) {
		
		ProjectBidsDTO projBids = null;
		
		Project proj = database.getProject(projectName);
		
		ArrayList<Bid> bids = new ArrayList<Bid>();
		
		List<Person> persons = database.getPersons();
		
		for (Person person : persons) {
			
			Bid b = database.getBid(person.getName(), projectName);
			if (b != null)
				bids.add(b);
			
		}		
		
		projBids = new ProjectBidsDTO(proj, bids);
		
		return projBids;
	}

}
