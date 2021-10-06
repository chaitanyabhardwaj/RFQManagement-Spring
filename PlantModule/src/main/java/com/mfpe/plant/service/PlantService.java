package com.mfpe.plant.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mfpe.plant.model.Demand;
import com.mfpe.plant.model.Part;
import com.mfpe.plant.model.PlantReorderDetails;
import com.mfpe.plant.model.ReorderRules;
import com.mfpe.plant.repos.DemandRepository;
import com.mfpe.plant.repos.PartRepository;
import com.mfpe.plant.repos.PlantReorderDetailsRepository;
import com.mfpe.plant.repos.ReorderRulesRepository;

@Service
public class PlantService {

	private static final Logger log = LoggerFactory.getLogger(PlantService.class);

	@Autowired
	private PartRepository partRepository;

	@Autowired
	private PlantReorderDetailsRepository plantReorderDetailsRepository;

	@Autowired
	private ReorderRulesRepository reorderRulesRepository;

	@Autowired
	private DemandRepository demandRepository;
	
	public ReorderRules findById(Integer partId) {
		log.info("Inside findById of PartService");
		return reorderRulesRepository.findByPartId(partId);
	}


//	public List<Part> findAll() {
//		log.info("Inside findAll of PartService");
//		return partRepository.findAll();
//	}

	public Part viewStockInHand(Integer partId) {
		log.info("Inside viewStockInHand of service");
		return partRepository.viewStockInHand(partId);
	}

	public List<PlantReorderDetails> findAllPartsInReorder() {
		log.info("Inside findAllPartsInReorder of plant service");
		List<PlantReorderDetails> plantReorderDetailsTemporaryList = new ArrayList<>();
		List<PlantReorderDetails> plantReorderDetailsList = plantReorderDetailsRepository.findAll();

		for (PlantReorderDetails plantReorderDetails : plantReorderDetailsList) {
			if (plantReorderDetails != null && plantReorderDetails.getReorderStatus().equalsIgnoreCase("pending")) {
				plantReorderDetailsTemporaryList.add(plantReorderDetails);
			}
		}
		return plantReorderDetailsTemporaryList;
	}

	public void saveReorderRules(ReorderRules reorderRules) {
		log.info("Inside save of PartService");
		reorderRulesRepository.save(reorderRules);
	}

	public Optional<Demand> findByDemandId(Integer demandId) {
		log.info("Inside findByDemandId of PartService");
		return demandRepository.findById(demandId);
	}

	public void saveReorderDetails(PlantReorderDetails plantReorderDetails) {
		log.info("Inside mera func");
		plantReorderDetailsRepository.save(plantReorderDetails);
	}

	public List<ReorderRules> findAllReorderRules() {
		System.out.println("PlantService");
		return reorderRulesRepository.findAll();
	}
	public List<Integer> findAllPartId() {
		return demandRepository.findAllPartId();
	}
	public Part findByPartId(Integer partId) {
		return partRepository.findByPartId(partId);
	}

	public Demand getDemandByPartId(Integer partId) {
		return demandRepository.getDemandByPartId(partId);
	}

}
