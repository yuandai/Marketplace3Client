package com.market.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.market.helper.BidHelper;
import com.market.helper.CommonHelper;
import com.market.helper.PersonHelper;
import com.market.helper.ProjectHelper;
import com.market.model.Bid;
import com.market.model.Person;
import com.market.model.Project;
import com.market.repo.BidRepository;
import com.market.repo.PersonRepository;
import com.market.repo.ProjectRepository;
import com.market.transfer.BidsDTO;
import com.market.transfer.ProjectBidsDTO;
import com.market.transfer.ProjectsDTO;

@RestController
public class WebController {
	@Autowired
	PersonRepository personRepo;
	@Autowired
	ProjectRepository projectRepo;
	@Autowired
	BidRepository bidRepo;
		
	@Autowired
	CommonHelper commonHelper;
	
    @Autowired
    public void setCommonHelper(CommonHelper commonHelper) {
        this.commonHelper = commonHelper;
    }
    
	@Autowired
	PersonHelper personHelper;
	
    @Autowired
    public void setPersonHelper(PersonHelper personHelper) {
        this.personHelper = personHelper;
    }
    
	@Autowired
	ProjectHelper projectHelper;
	
    @Autowired
    public void setProjectHelper(ProjectHelper projectHelper) {
        this.projectHelper = projectHelper;
    }
    
	@Autowired
	BidHelper bidHelper;
	
    @Autowired
    public void setBidHelper(BidHelper bidHelper) {
        this.bidHelper = bidHelper;
    }
    
    
	/*
	 * Bid RestAPIs
	 */

	
	@GetMapping("/MarketPlace/rest/service/bidsByPerson")		
	public ResponseEntity<?> responseBid(@RequestParam("name") String name) {
												
		BidsDTO bidDTO = bidHelper.getBidsOfPerson(name);
			
		return ResponseEntity.ok(bidDTO);
								
	}
	
	@GetMapping("/MarketPlace/rest/service/bidsByProject")		
	public ResponseEntity<?> responseBidProject(@RequestParam("projectName") String projectName ) {
												
		ProjectBidsDTO projBidsDTO = projectHelper.getProjectWithAllBids(projectName); 
				
		return ResponseEntity.ok(projBidsDTO);
					
	}

	
	

	@PostMapping("/MarketPlace/rest/service/bids")		
	public ResponseEntity<?> createBid(@Valid @RequestBody Bid bid, Errors errors) {
									
		boolean result = bidHelper.createBid(bid);
			
		if (result)
			return ResponseEntity.ok(Constant.successMsg);
		else
			return ResponseEntity.ok(Constant.errMsg);
			
	}
	
	
	@PutMapping("/MarketPlace/rest/service/bids")		
	public ResponseEntity<?> updateBid(@Valid @RequestBody Bid bid, Errors errors) {
									
		boolean result = bidHelper.updateBid(bid);
			
		if (result)
			return ResponseEntity.ok(Constant.successMsg);
		else
			return ResponseEntity.ok(Constant.errMsg);
			
	}
    
    
	/*
	 * Person RestAPIs
	 */
	
	
	@PostMapping("/MarketPlace/rest/service/persons")	
	public ResponseEntity<?> createPerson(@Valid @RequestBody Person person, Errors errors) {
									
        
		boolean result = personHelper.createPerson(person);
			
		if (result)
			return ResponseEntity.ok(Constant.successMsg);
		else
			return ResponseEntity.ok(Constant.errMsg);
			
	}
	
    
	/*
	 * Project RestAPIs
	 */
	
	
	@GetMapping("/MarketPlace/rest/service/projects")		
	public ResponseEntity<?> responseProject(@RequestParam("name") String name) {
						        	
		ProjectsDTO projDTO = projectHelper.getProjectsOfPerson(name);
		return ResponseEntity.ok(projDTO);
					
	}
    
	@PostMapping("/MarketPlace/rest/service/projects")		
	public ResponseEntity<?> createProject(@Valid @RequestBody Project project, Errors errors) {
									
		boolean result = projectHelper.createProject(project);
			
		if (result)
			return ResponseEntity.ok(Constant.successMsg);
		else
			return ResponseEntity.ok(Constant.errMsg);

	}
	
	@PutMapping("/MarketPlace/rest/service/projects")		
	public ResponseEntity<?> updateProject(@Valid @RequestBody Project project, Errors errors) {
									
		boolean result = projectHelper.updateProject(project);
			
		if (result)
			return ResponseEntity.ok(Constant.successMsg);
		else
			return ResponseEntity.ok(Constant.errMsg);

	}
	
    
	/*
	 * Other RestAPIs
	 */
    
    
	@PostMapping("/MarketPlace/rest/service/initial")
	public ResponseEntity<?> initial() {
		        
		commonHelper.initial();
		return ResponseEntity.ok(Constant.successMsg);

	}
	
	@PostMapping("/MarketPlace/rest/service/assign")
	public ResponseEntity<?> assign() {
									        
		commonHelper.assign();
		return ResponseEntity.ok(Constant.successMsg);

	}
	
	
	
	
}

