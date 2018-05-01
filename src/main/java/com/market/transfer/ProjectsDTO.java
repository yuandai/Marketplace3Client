package com.market.transfer;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import com.market.model.Project;

/*
 * Data Transfer Object
 */

public class ProjectsDTO {
	
	private List<ProjectDTO> projects;
	
	public ProjectsDTO() {
		this.projects = new ArrayList<ProjectDTO>();
	}
	
	public ProjectsDTO(List<Project> projList) {
		projects = new ArrayList<ProjectDTO>();

		for (Project proj : projList) {
			ProjectDTO pj = new ProjectDTO();
			
			pj.setBudget(proj.getBudget());
			if (proj.getAssignee() != null) {
				pj.setAssigneeName(proj.getAssignee().getName());
			}
			pj.setOwnerName(proj.getOwner().getName());
			pj.setProjectName(proj.getProjectName());
			pj.setDescription(proj.getDescription());
			SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/YY");
			pj.setEndingDate(sdf.format(proj.getEndingDate()));
						
			projects.add(pj);
		}
		
	}

		
	public void setProjects(List<ProjectDTO> projects) {
		this.projects = projects;
	}
	
	public List<ProjectDTO> getProjects() {
		return this.projects;
	}

}

