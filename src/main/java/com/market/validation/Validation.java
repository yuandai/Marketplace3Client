package com.market.validation;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.market.model.Bid;
import com.market.model.Database;
import com.market.model.Person;
import com.market.model.Project;

/*
 * Validations
 */

@Service
public class Validation {
	
	@Autowired
	Database database;
	
	@Autowired
	public void setDatabase(Database database) {
		this.database = database;
	}	
	
	public boolean validateUpdateProject(Project project) {
		

		String projectName = project.getProjectName();
		
		/* project name cannot be null */
		if (projectName == null || projectName.equals(""))
			return false;
		
		Project pj = database.getProject(projectName);
		
		/* can only update a existing project */
		if (pj == null) {
			return false;
		} else {
			project.setId(pj.getId());
		}
		
		/* project owner must register first */
		String owner = project.getOwner().getName();
		
		Person person = database.getPersonByName(owner);
		
		if (person == null) {
			return false;
		}
		
		/* project can only be auto assigned */
		Person engineer = project.getAssignee();//.getName();
		if (engineer != null)
			return false;
		
		Date endingDate = project.getEndingDate();
		
		/* project ending date cannot be null */
		if (endingDate == null)
			return false;
		
		/* ending date should be in the future */
		if (endingDate.compareTo(new Date()) <= 0)
			return false;
		
		return true;
		
	}

	
	public boolean validateCreateProject(Project project) {
		
		
		String projectName = project.getProjectName();
		
		/* project name cannot be null */
		if (projectName == null || projectName.equals(""))
			return false;
		
		/* check duplicated project */
		Project pj = database.getProject(projectName);
		
		if (pj != null) {
			return false;
		}
		
		/* project owner must register first */
		String owner = project.getOwner().getName();
		
		Person person = database.getPersonByName(owner);
		
		if (person == null) {
			return false;
		}
		
		/* projects can only be auto assigned */
		Person engineer = project.getAssignee();//.getName();
		if (engineer != null)
			return false;
		
		Date endingDate = project.getEndingDate();
		
		/* project ending date cannot be null */
		if (endingDate == null)
			return false;
		
		/* ending date should be in future */
		if (endingDate.compareTo(new Date()) <= 0)
			return false;
		
		return true;
		
	}
	
	
	public boolean validateUpdateBid(Bid bid) {
		
		
		/* bid must exists for update */
		String name = bid.getEngineer().getName();
		String projectName = bid.getProject().getProjectName();
		
		Bid bd = database.getBid(name, projectName);
		
		if (bd == null) {
			return false;
		} else {
			bid.setId(bd.getId());
		}
		
		/* engineer must register first */
		Person person = database.getPersonByName(name);
		
		if (person == null) {
			return false;
		}
		
		/* project must exists before update a bid */
		Project project = database.getProject(projectName);
		if (project == null)
			return false;
		
		
		/* cannot update a bid for assigned project */
		if (database.getProject(projectName).getAssignee()/*.getName()*/ != null)
			return false;

		
		return true;
		
	}

	
	public boolean validateCreateBid(Bid bid) {
		
		
		/* a engineer can only bid a project once */
		String name = bid.getEngineer().getName();
		String projectName = bid.getProject().getProjectName();
		
		Bid bd = database.getBid(name, projectName);
		
		if (bd != null) {
			return false;
		}
		
		/* engineer must register first */
		Person person = database.getPersonByName(name);
		
		if (person == null) {
			return false;
		}
		
		/* project must exists before create a bid */
		Project project = database.getProject(projectName);
		if (project == null)
			return false;
		
		/* cannot create a bid for assigned project */
		if (database.getProject(projectName).getAssignee()/*.getName()*/ != null)
			return false;
		
		return true;
		
	}
	
	public boolean validateCreatePerson(Person person) {
		
		
		String name = person.getName();
		
		/* person name cannot be null */
		if (name == null || name.equals(""))
			return false;
		
		/* duplicated person name */
		Person ps = database.getPersonByName(name);
		
		if (ps != null) {
			return false;
		}

		return true;
		
	}

}
