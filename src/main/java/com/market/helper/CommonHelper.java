package com.market.helper;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.market.model.Bid;
import com.market.model.Database;
import com.market.model.Person;
import com.market.model.Project;

/*
 * Business Object
 */

@Service
@Transactional
public class CommonHelper {
	
	@Autowired
	Database database;
	
    @Autowired
	public void setDatabase(Database database) {
		this.database = database;
	}
	
	public void initial() {
		
		Person mark = database.savePerson(new Person("Mark", "408-1234567"));
		Person jonathan = database.savePerson(new Person("Jonathan", "408-7654321"));
		database.savePerson(new Person("Gorden", "408-1357902"));
		
		Project pcRepair = database.saveProject(new Project("PCRepair", 
				"PC auto reboot", 
				new BigDecimal(100), 
				new Date(),
				mark));
		
		database.saveBid(new Bid(jonathan, 
				pcRepair,
				"5 years PC repair experience", 
				new BigDecimal(90)));
		
		
	}
	

	public void assign() {
		
		List<Project> projs = database.getProjectsWithoutAssignee();
		
		for (Project proj : projs) {
			
				Bid selected = null;
				
				List<Bid> bidList;
				bidList = database.getBidByProjectName(proj.getProjectName());
				
				
				
				selected = bestBid(bidList);
				
				if (selected != null) {
					
					proj.setAssignee(selected.getEngineer());
					database.saveProject(proj);
					
				} else {
					
					Calendar c = Calendar.getInstance();
					c.add(Calendar.MONTH, 1);
					proj.setEndingDate(c.getTime());
				
				}
		}
		

	}


	private Bid bestBid(List<Bid> bidList) {
		
		if (bidList == null || bidList.size() == 0)
			return null;
				
		Collections.sort(bidList, new Comparator<Bid> () {
				
			public int compare(Bid o1, Bid o2) {
				
				if (o1.getAmount() == o2.getAmount())
					return 0;
				else if (o1.getAmount().compareTo(o2.getAmount()) > 0)
					return 1;
				else
					return -1;
					
				
			}
		});
		
		Bid selected = bidList.get(0);
		
		
		return selected;
		
	}
	
	
	
}
