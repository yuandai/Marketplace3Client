package com.market.repo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.market.model.Person;

public interface PersonRepository extends CrudRepository<Person, Long>{
	List<Person> findByName(String name);
}
