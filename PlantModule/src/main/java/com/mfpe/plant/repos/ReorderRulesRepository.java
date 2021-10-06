package com.mfpe.plant.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.mfpe.plant.model.ReorderRules;

@Repository
public interface ReorderRulesRepository extends JpaRepository<ReorderRules, Integer> {
	@Query(value="select * from reorder_rules where part_id= :partId",nativeQuery=true)
	ReorderRules findByPartId(Integer partId);
}
