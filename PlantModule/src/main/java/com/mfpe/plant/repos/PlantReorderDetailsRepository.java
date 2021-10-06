package com.mfpe.plant.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mfpe.plant.model.PlantReorderDetails;

@Repository
public interface PlantReorderDetailsRepository extends JpaRepository<PlantReorderDetails, Integer> {

}
