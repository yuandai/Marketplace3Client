package com.market.transfer;

import java.math.BigDecimal;

public class ProjectDTO {
	
	private String projectName;
	private String description;
	private BigDecimal budget;
	private String endingDate;
	private String assigneeName = "";
	private String ownerName;
	
	
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	
	public String getProjectName() {
		return projectName;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	public String getDescription() {
		return description;
	}

	public void setBudget(BigDecimal budget) {
		this.budget = budget;
	}
	
	public BigDecimal getBudget() {
		return budget;
	}

	public void setEndingDate(String endingDate) {
		this.endingDate = endingDate;
	}
	
	public String getEndingDate() {
		return endingDate;
	}

	public void setAssigneeName(String assigneeName) {
		this.assigneeName = assigneeName;
	}
	
	public String getAssigneeName() {
		return assigneeName;
	}
	
	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}
	
	public String getOwnerName() {
		return ownerName;
	}
	

}
