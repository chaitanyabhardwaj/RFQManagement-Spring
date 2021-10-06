package com.mfpe.plant.controller;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.mfpe.plant.model.Demand;
import com.mfpe.plant.model.Part;
import com.mfpe.plant.model.PlantReorderDetails;
import com.mfpe.plant.model.ReorderRules;
import com.mfpe.plant.service.PlantService;

import javax.persistence.EntityNotFoundException;

@RestController
@RequestMapping("/plant")
public class PlantController {
	private static final Logger log = LoggerFactory.getLogger(PlantController.class);

	@Autowired
	private PlantService plantService;

	@GetMapping("/viewPartsReOrder")
	public ResponseEntity<List<PlantReorderDetails>> viewPartsReorder() {
		log.info("Inside ViewPartsReorder of PartController");
		List<Integer> dl = plantService.findAllPartId();
//		List<PlantReorderDetails> prdl = new ArrayList<PlantReorderDetails>();
		for (Integer x : dl) {
			Part part = plantService.viewStockInHand(x);
			ReorderRules rr = plantService.findById(x);
			if (rr != null) {
				if (part.getStockInHand() <= rr.getMinQuantity()) {
					long millis = System.currentTimeMillis();
					java.sql.Date date = new java.sql.Date(millis);
					PlantReorderDetails prd = new PlantReorderDetails(x, "pending", date);
					plantService.saveReorderDetails(prd);
				}
			}
		}
		return new ResponseEntity<List<PlantReorderDetails>>(plantService.findAllPartsInReorder(),HttpStatus.OK);
	}

	@GetMapping("/viewStockInHand/{id}")
	public ResponseEntity<Part> viewStockInHand(@PathVariable("id") Integer partId) {
		log.info("Inside viewStockInHand of PartController");
		try {
			Part part = plantService.viewStockInHand(partId);
//			System.out.println(new ResponseEntity<Part>(part, HttpStatus.OK));
			return new ResponseEntity<Part>(part, HttpStatus.OK);
		} catch (NoSuchElementException e) {
			return new ResponseEntity<Part>(HttpStatus.NOT_FOUND);
		}
	}

	@PostMapping("/updateMinMaxQuantity")
	public ResponseEntity<String> updateMinMaxQuantities(@RequestBody ReorderRules reorderRules) {
		log.info("Inside updateMinMaxQuantities of PartController");
		try {
			ReorderRules reorderRulesTemplate = plantService.findById(reorderRules.getPartId());
			if (reorderRulesTemplate != null) {
				Optional<Demand> demand = plantService.findByDemandId(reorderRulesTemplate.getDemandId());
				Integer minQuantity = reorderRules.getMinQuantity();
				Integer maxQuantity = reorderRules.getMaxQuantity();
				if (maxQuantity < (demand.get().getDemandCount() * 20) / 100)
					reorderRulesTemplate.setMaxQuantity(reorderRules.getMaxQuantity());
				else
					return new ResponseEntity<String>("Maximum limit exceeding", HttpStatus.OK);

				if (minQuantity > (maxQuantity * 30) / 100 && minQuantity < (maxQuantity * 50) / 100)
					reorderRulesTemplate.setMinQuantity(reorderRules.getMinQuantity());
				else
					return new ResponseEntity<String>("Minimum limit receding", HttpStatus.OK);

				reorderRulesTemplate.setReorderFrequency(reorderRules.getMaxQuantity() - reorderRules.getMinQuantity());
				plantService.saveReorderRules(reorderRulesTemplate);
				return new ResponseEntity<String>("Updated", HttpStatus.OK);
			} else
				return new ResponseEntity<String>(
						"PartId not found. Please provide valid partId to update min and max quantities",
						HttpStatus.NOT_FOUND);
		} catch (NoSuchElementException e) {
			return new ResponseEntity<String>(
					"PartId not found. Please provide valid partId to update min and max quantities",
					HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping("/getReorderRules")
	public ResponseEntity<List<ReorderRules>> getAllReorderRules() {
		log.info("Inside getReorderRules of PartController");
		return new ResponseEntity<List<ReorderRules>>(plantService.findAllReorderRules(), HttpStatus.OK);
	}

	@GetMapping("/getPartById/{partId}")
	public ResponseEntity<Part> getPartById(@PathVariable Integer partId) {
		log.info("Inside getPartById of PartController");
		try {
			Part part = plantService.findByPartId(partId);
			return new ResponseEntity<>(part, HttpStatus.OK);
		}
		catch(EntityNotFoundException ex) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@GetMapping("/getDemandIdByPartId/{partId}")
	public ResponseEntity<Long> getDemandIdByPartId(@PathVariable Integer partId) {
		log.info("Inside getDemandByPartId of PartController");
		try {
			return new ResponseEntity<>((long)plantService.getDemandByPartId(partId).getDemandId(), HttpStatus.OK);
		}
		catch(EntityNotFoundException ex) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

}
