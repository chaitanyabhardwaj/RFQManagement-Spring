package com.mrfq.fabricateapp.feign;

import java.util.List;

import com.mrfq.fabricateapp.dto.Part;
import com.mrfq.fabricateapp.dto.ReorderRules;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.mrfq.fabricateapp.dto.PlantReorderDetails;

@FeignClient("GATEWAY-SERVICE")
//@ComponentScan("com.project.fabricateapp.controller")
public interface PlantFeign {

	@GetMapping("/plant/viewPartsReOrder")
	public ResponseEntity<List<PlantReorderDetails>> viewPartsReorder();
	
	@GetMapping("/plant/viewStockInHand/{id}")
	public ResponseEntity<Part> viewStockInHand(@PathVariable("id") Integer partId) ;

	@PostMapping("/plant/updateMinMaxQuantity")
	public ResponseEntity<String> updateMinMaxQuantities(@RequestBody ReorderRules reorderRules) ;
		
	@GetMapping("/plant/getReorderRules")
	public ResponseEntity<List<ReorderRules>> getAllReorderRules();
}
