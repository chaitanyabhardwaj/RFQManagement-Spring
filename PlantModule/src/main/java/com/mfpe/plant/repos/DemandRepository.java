package com.mfpe.plant.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.mfpe.plant.model.Demand;

@Repository
public interface DemandRepository extends JpaRepository<Demand, Integer> {

	@Query(value="select part_id from Demand",nativeQuery=true)
	public List<Integer> findAllPartId();

	Demand getDemandByPartId(Integer partId);

}
