package com.market.transfer;

import java.math.BigDecimal;

public class BidDTO {
	
	private String proposal;
	private BigDecimal amount;
	private String engineerName;
	private String projectName;
	
	public void setProposal(String proposal) {
		this.proposal = proposal;
	}
	
	public String getProposal() {
		return this.proposal;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}
	
	public BigDecimal getAmount() {
		return this.amount;
	}

	public void setEngineerName(String engineerName) {
		this.engineerName = engineerName;
	}
	
	public String getEngineerName() {
		return this.engineerName;
	}
	
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	
	public String getProjectName() {
		return this.projectName;
	}

}
