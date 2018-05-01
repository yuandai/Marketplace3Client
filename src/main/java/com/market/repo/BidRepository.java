package com.market.repo;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.market.model.Bid;

public interface BidRepository extends CrudRepository<Bid, Long>{
	List<Bid> findByAmount(BigDecimal amount);
	@Query("select b from Bid b where b.engineer.name = ?1 and b.project.projectName = ?2 ")
	List<Bid> findByEngineerNameAndProjectName(String engineerName, String projectName);
	@Query("select b from Bid b where b.project.projectName = ?1 ")
	List<Bid> findByProjectName(String projectName);
	@Query("select b from Bid b where b.engineer.name = ?1 ")
	List<Bid> findByEngineerName(String engineerName);
}
