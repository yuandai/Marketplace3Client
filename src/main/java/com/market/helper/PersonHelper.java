package com.market.helper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.market.model.Database;
import com.market.model.Person;
import com.market.validation.Validation;

/*
 * Business Object
 */

@Service
@Transactional
public class PersonHelper {
	
	@Autowired
	Database database;
	@Autowired
	Validation validation;
	
	@Autowired
	public void setDatabase(Database database) {
		this.database = database;
	}
	
	@Autowired
	public void setValidation(Validation validation) {
		this.validation = validation;
	}
	
	public boolean createPerson(Person person) {
		boolean result = false;
		
		if (validation.validateCreatePerson(person)) {
			
			database.savePerson(person);
			result = true;
			
		} else 
			
			result = false;
		
		return result;
	}

}
