package com.market.transfer;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import com.market.model.Bid;
import com.market.model.Project;

/*
 * Data Transfer Object
 */

public class ProjectBidsDTO {
	
	private ProjectDTO project;
	private ArrayList<BidDTO> bids;
	

	public ProjectBidsDTO(Project proj, List<Bid> bidList) {
		
			project = new ProjectDTO();
			
			project.setBudget(proj.getBudget());
			if (proj.getAssignee() != null) {
				project.setAssigneeName(proj.getAssignee().getName());
			}
			project.setOwnerName(proj.getOwner().getName());
			project.setProjectName(proj.getProjectName());
			project.setDescription(proj.getDescription());
			SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/YY");
			project.setEndingDate(sdf.format(proj.getEndingDate()));
						
			bids = new ArrayList<BidDTO>();

			for (Bid bid : bidList) {
				BidDTO bd = new BidDTO();
				
				bd.setAmount(bid.getAmount());
				bd.setEngineerName(bid.getEngineer().getName());
				bd.setProjectName(bid.getProject().getProjectName());
				bd.setProposal(bid.getProposal());
				
				bids.add(bd);
			}
		
	}
	
	
	
	
	public void setProject(ProjectDTO project) {
		this.project = project;
	}
	
	public ProjectDTO getProject() {
		return project;
	}

	public void setBids(ArrayList<BidDTO> bids) {
		this.bids = bids;
	}
	
	public ArrayList<BidDTO> getBids() {
		return bids;
	}

	
}
