package com.market.transfer;

import java.util.ArrayList;
import java.util.List;

import com.market.model.Bid;

/*
 * Data Transfer Object
 */

public class BidsDTO {
	
	private List<BidDTO> bids;
	
	public BidsDTO() {
		bids = new ArrayList<BidDTO>();
	}
	
	public BidsDTO(List<Bid> bidList) {
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
	
	public void setBids(List<BidDTO> bids) {
		this.bids = bids;
	}
	
	public List<BidDTO> getBids() {
		return this.bids;
	}

}

