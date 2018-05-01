package com.market.model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.market.repo.BidRepository;
import com.market.repo.PersonRepository;
import com.market.repo.ProjectRepository;


/*
 * DAO Object
 */

@Service
public class Database /*extends HibernateDaoSupport*/ {
	
	@Autowired
	PersonRepository personRepo;
	@Autowired
	ProjectRepository projectRepo;
	@Autowired
	BidRepository bidRepo;
	
	public Person savePerson(Person person) {
		
		Person p = personRepo.save(person);
		        
		return p;                
	}
	
	public Person getPersonByName(String name) {
		
		List<Person> list = personRepo.findByName(name);
		
        if (list != null && list.size() > 0)
        	return (Person)list.get(0);
        else
        	return null;
		
	}

	
	public List<Person> getPersons() {
		
		Iterable<Person> list = personRepo.findAll();
		List<Person> personList = new ArrayList<Person>();
		
		list.forEach(personList::add);

        return personList;
	}


	public Project saveProject(Project project) {
		
        Project proj = projectRepo.save(project);

		return proj;
	}
	
	public Project getProject(String projectName) {
		
		List<Project> list = projectRepo.findByProjectName(projectName);
		
        if (list != null && list.size() >= 1)
        	return (Project)list.get(0);
        else
        	return null;
		
	}
	
	public List<Project> getProjectsWithoutAssignee() {
		
		List<Project> list = projectRepo.findWithoutAssignee();
		
		return list;
		
	}
	
	public List<Project> getProjectsByOwnerName(String name) {
		
		List<Project> list = projectRepo.findByOwnerName(name);
		
		return list;
		
	}


	public Bid saveBid(Bid bid) {
		
		List<Person> list = personRepo.findByName(bid.getEngineer().getName());
		Person person = (Person)list.get(0);
        bid.setEngineer(person);
        
        List<Project> listProject = projectRepo.findByProjectName(bid.getProject().getProjectName());
        Project project = (Project)listProject.get(0);
        bid.setProject(project);
        
        bidRepo.save(bid);
        
        return bid;

	}
	
	
	public Bid getBid(String name, String projectName) {
		
		List<Bid> list = bidRepo.findByEngineerNameAndProjectName(name, projectName);
		
        if (list != null && list.size() >= 1)
        	return list.get(0);
        else
        	return null;
		
	}
	
	public List<Bid> getBidByProjectName(String projectName) {
		
		List<Bid> list = bidRepo.findByProjectName(projectName);
		
		return list;
				
	}
	
	public List<Bid> getBidsByEngineerName(String engineerName) {
		
		List<Bid> list = bidRepo.findByEngineerName(engineerName);
		
		return list;
				
	}



}
