package com.market.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.market.helper.RemoteHelper;
import com.market.model.Bid;
import com.market.model.Person;
import com.market.model.Project;
import com.market.transfer.BidsDTO;
import com.market.transfer.ProjectBidsDTO;
import com.market.transfer.ProjectsDTO;

@RestController
public class WebController {
		
	@Autowired
	RemoteHelper remoteHelper;

	
    
	/*
	 * Bid RestAPIs
	 */

	
	@GetMapping("/rest/service/bidsByPerson")		
	public ResponseEntity<?> responseBid(@RequestParam("name") String name) {
												
		BidsDTO bidDTO = remoteHelper.getBidsOfPerson(name);
			
		return ResponseEntity.ok(bidDTO);
								
	}
	
	@GetMapping("/rest/service/bidsByProject")		
	public ResponseEntity<?> responseBidProject(@RequestParam("projectName") String projectName ) {
												
		ProjectBidsDTO projBidsDTO = remoteHelper.getProjectWithAllBids(projectName); 
				
		return ResponseEntity.ok(projBidsDTO);
					
	}

	
	

	@PostMapping("/rest/service/bids")		
	public ResponseEntity<?> createBid(@Valid @RequestBody Bid bid, Errors errors) {
									
		boolean result = remoteHelper.createBid(bid);
			
		if (result)
			return new ResponseEntity(HttpStatus.OK);
		else
			return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
			
	}
	
	
	@PutMapping("/rest/service/bids")		
	public ResponseEntity<?> updateBid(@Valid @RequestBody Bid bid, Errors errors) {
									
		boolean result = remoteHelper.updateBid(bid);
			
		if (result)
			return new ResponseEntity(HttpStatus.OK);
		else
			return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
			
	}
    
    
	/*
	 * Person RestAPIs
	 */
	
	
	@PostMapping("/rest/service/persons")	
	public ResponseEntity<?> createPerson(@Valid @RequestBody Person person, Errors errors) {
									
        
		boolean result = remoteHelper.createPerson(person);
			
		if (result)
			return new ResponseEntity(HttpStatus.OK);
		else
			return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
			
	}
	
    
	/*
	 * Project RestAPIs
	 */
	
	
	@GetMapping("/rest/service/projects")		
	public ResponseEntity<?> responseProject(@RequestParam("name") String name) {
						        	
		ProjectsDTO projDTO = remoteHelper.getProjectsOfPerson(name);
		return ResponseEntity.ok(projDTO);
					
	}
    
	@PostMapping("/rest/service/projects")		
	public ResponseEntity<?> createProject(@Valid @RequestBody Project project, Errors errors) {
									
		boolean result = remoteHelper.createProject(project);
			
		if (result)
			return new ResponseEntity(HttpStatus.OK);
		else
			return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);

	}
	
	@PutMapping("/rest/service/projects")		
	public ResponseEntity<?> updateProject(@Valid @RequestBody Project project, Errors errors) {
									
		boolean result = remoteHelper.updateProject(project);
			
		if (result)
			return new ResponseEntity(HttpStatus.OK);
		else
			return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);

	}
	
    
	/*
	 * Other RestAPIs
	 */
    
    
	@PostMapping("/rest/service/initial")
	public ResponseEntity<?> initial() {
		        
		remoteHelper.initial();
		return new ResponseEntity(HttpStatus.NO_CONTENT);

	}
	
	@PostMapping("/rest/service/assign")
	public ResponseEntity<?> assign() {
									        
		remoteHelper.assign();
		return new ResponseEntity(HttpStatus.NO_CONTENT);

	}
	
	
	
	
}

