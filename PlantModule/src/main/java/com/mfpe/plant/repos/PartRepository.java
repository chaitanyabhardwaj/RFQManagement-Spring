package com.mfpe.plant.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.mfpe.plant.model.Part;

@Repository
public interface PartRepository extends JpaRepository<Part, Integer> {
	
	@Query("SELECT p FROM Part p WHERE p.partId = :partId")
	public Part viewStockInHand(@Param("partId") int partId);

	@Query("SELECT p FROM Part p WHERE p.partId = :partId")
	public Part findByPartId(@Param("partId") int partId);
}
