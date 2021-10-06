package com.mrfq.fabricateapp.service;

import java.util.Arrays;
import java.util.List;

import com.mrfq.fabricateapp.dto.*;
import com.mrfq.fabricateapp.feign.SupplierClient;
import com.mrfq.fabricateapp.dto.*;
import com.mrfq.fabricateapp.feign.RfqClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class FabricateService {

	@Autowired
	RestTemplate restTemplate;

	@Autowired
	private SupplierClient supplierClient;

	@Autowired
	private RfqClient rfqClient;
	
	
	
	public List<SupplierDTO> getAll(){
		//SupplierDTO [] supplierList= restTemplate.getForObject("http://localhost:8081/supplier/getAllSuppliers",Supplier [].class );
		//List<Supplier> suppliersList = Arrays.asList(supplierList);
		return supplierClient.getAllSuppliers();
	}
	
	public void addsupplier(SupplierPartDTO supplier) {
		//System.out.println("adding in");
		//restTemplate.postForObject("http://localhost:8081/supplier/addSupplier",supplier,Supplier.class);
		supplierClient.addSupplier(supplier);
	}
	
	public SupplierDTO editsupplier(SupplierDTO supplier) {
		//System.out.println("adding in");
		//return restTemplate.postForObject("http://localhost:8081/supplier/editSupplier",supplier,Supplier.class);
		return supplierClient.editSupplier(supplier);
	}
	
	public void updateFeedback(SupplierDTO supplier)
	{
		// restTemplate.postForObject("http://localhost:8081/supplier/updateFeedback",supplier,String.class);
		supplierClient.updateFeedback(supplier);
	}
	
	public Part viewStockInHands(Integer partId)
	{
		Part part = restTemplate.getForObject("http://localhost:8761/viewStockInHand/"+partId, Part.class);
		//List<Part> part1 = Arrays.asList(part);
		return part;
	}
	
	public List<PlantReorderDetails> viewPartReorderDetails()
	{
		PlantReorderDetails [] plant_Reorder_Details = restTemplate.getForObject("http://localhost:8761/viewPartsReOrder",PlantReorderDetails [].class );
        List<PlantReorderDetails> plant_Reorder_Details1 = Arrays.asList(plant_Reorder_Details);
        return plant_Reorder_Details1;
	}
	
	public String updateMinMaxQuantities(ReorderRules reorderRules)
	{
		System.out.println("fab service");
		String status =restTemplate.postForObject("http://localhost:8761/updateMinMaxQuantity", reorderRules,String.class);
		return status;
	}
	
	
	//RFQ
	public List<RfqDetail> getRfqOfPlant(Long plantId)
	{
		System.out.println("Fab service");
		//RFQ [] rfq = restTemplate.getForObject("http://localhost:8012/getRFQOfPlant/"+plantId,RFQ [].class);
		//List<RFQ> rfq1 = Arrays.asList(rfq);

		//get rfq
		Rfq rfq = rfqClient.getRfqOfPlant(plantId);
		//fetch rfq details
		return rfqClient.getRfqDetail(rfq.getId());
	}
	
	public ResponseEntity<List<SupplierDTO>> getPotentialVendorsOfRFQ(Long rfqId)
	{
		//Supplier []  supplierList = restTemplate.getForObject("http://localhost:8082/getPotentialVendorsOfRFQ/"+rfqid, Supplier[].class);
	    //List<Supplier> suppliersList = Arrays.asList(supplierList);
	    return rfqClient.getPotentialVendorsOfRfq(rfqId);
	}

	public SupplierPartDTO createSupplierPartDTO(String supplierName, String email, String phone, String location, int feedback, Long partId, String partName, int quantity, int timePeriod) {
		SupplierDTO supplierDTO = new SupplierDTO();
		supplierDTO.setName(supplierName);
		supplierDTO.setEmail(email);
		supplierDTO.setPhone(phone);
		supplierDTO.setLocation(location);
		supplierDTO.setFeedback(feedback);

		PartDTO partDTO = new PartDTO();
		partDTO.setPartId(partId);
		partDTO.setName(partName);
		partDTO.setQuantity(quantity);
		partDTO.setTimePeriod(timePeriod);

		return new SupplierPartDTO(supplierDTO, partDTO);
	}

}
