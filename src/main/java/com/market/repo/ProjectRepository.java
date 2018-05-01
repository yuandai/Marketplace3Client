package com.market.repo;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.market.model.Project;

public interface ProjectRepository extends CrudRepository<Project, Long>{
	
	List<Project> findByProjectName(String projectName);
	@Query("select p from Project p where p.owner.name = ?1 ")
	List<Project> findByOwnerName(String ownerName);
	@Query("select p from Project p where p.assignee = null and endingDate <= current_date ")
	List<Project> findWithoutAssignee();

}
