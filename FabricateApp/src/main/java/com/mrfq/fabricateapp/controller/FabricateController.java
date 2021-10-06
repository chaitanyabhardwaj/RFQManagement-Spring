package com.mrfq.fabricateapp.controller;

import java.text.ParseException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.mrfq.fabricateapp.dto.*;
import com.mrfq.fabricateapp.feign.PlantFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.http.ResponseEntity;
import com.mrfq.fabricateapp.service.FabricateService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class FabricateController {

	@Autowired
	private RestTemplate restTemplate;

	@Autowired
	private FabricateService fabricateService;
	
	@Autowired
	private PlantFeign plantFeign;

	public Boolean check(String token) {
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.add("Authorization", token);
		HttpEntity<?> httpEntity = new HttpEntity<>(httpHeaders);
		@SuppressWarnings("unused")
		ResponseEntity<JwtResponse> response1 = restTemplate.exchange("http://localhost:8089/validate", HttpMethod.GET,
				httpEntity, JwtResponse.class);
		JwtResponse j = response1.getBody();
		return j.isValid();
	}

	@RequestMapping("/")
	public ModelAndView goToLogin() {
		ModelAndView mv = new ModelAndView("login");
		return mv;
	}

	@RequestMapping("/login")
	public ModelAndView goToLoginpage() {
		ModelAndView mv = new ModelAndView("login");
		return mv;
	}

	String token;

	@RequestMapping(value = "/auth")
	public ModelAndView goToAuth(HttpServletRequest request) {
		UserLoginCredential userLoginCredential = new UserLoginCredential();
		userLoginCredential.setUserid(request.getParameter("userid"));
		userLoginCredential.setPassword(request.getParameter("password"));
		// String token;
		ModelAndView mv = new ModelAndView("home");
		try {
			String token1 = restTemplate.postForObject("http://localhost:8089/login", userLoginCredential,
					String.class);
			token = "Bearer" + " " + token1;
			mv.addObject("invalid", new String(""));
			mv.setViewName("home");
		} catch (Exception e) {
			// TODO: handle exception
			mv.addObject("invalid", new String("Invalid Credentials"));
			mv.setViewName("login");
		}

		// response.addHeader("token", token);
		return mv;
	}

	@RequestMapping(value = "/home")
	public ModelAndView goToHomePage() {
		ModelAndView mv = new ModelAndView("home");
		return mv;
	}

	@RequestMapping(value = "/plantpage")
	public ModelAndView goToAddNewPlantPage() {
		ModelAndView modelAndView = new ModelAndView();
	
		try {
			if (check(token)) {
				modelAndView.setViewName("plantpage");
			}
			else {
				modelAndView.addObject("error", "Invalid Credentials/Timeout");
				modelAndView.setViewName("login");
			}
			return modelAndView;
		} catch (Exception e) {
			modelAndView.addObject("error", e.getMessage());
			modelAndView.addObject("errorMsg", e.getStackTrace().toString());
			modelAndView.setViewName("home");
			return modelAndView;
		}
	}

	@RequestMapping(value = "/addsupplier")
	public ModelAndView goToAddNewSupplierPage() {

		ModelAndView modelAndView = new ModelAndView();
		try {
			if (check(token)) {
				modelAndView.setViewName("addsupplier");
			}
			else {
				modelAndView.addObject("error", "Invalid Credentials/Timeout");
				modelAndView.setViewName("login");
			}
			return modelAndView;
		} catch (Exception e) {
			// TODO: handle exception
			modelAndView.addObject("error", e.getMessage());
			modelAndView.addObject("errorMsg", e.getStackTrace().toString());
			modelAndView.setViewName("supplierpage");
			return modelAndView;
		}
	}

	@RequestMapping(value = "/updateFeedback")
	public ModelAndView goToFeedbackpage() {
		ModelAndView mv = new ModelAndView();
		try {
			if (check(token)) {
				mv.setViewName("updateFeedback");
			}
			else {
				mv.addObject("error", "Invalid Credentials/Timeout");
				mv.setViewName("login");
			}
			return mv;
		} catch (Exception e) {
			// TODO: handle exception
			mv.addObject("error", e.getMessage());
			mv.addObject("errorMsg", e.getStackTrace().toString());
			mv.setViewName("supplierpage");
			return mv;
		}
	}

	@RequestMapping(value = "/updateMinMaxQuantities")
	public ModelAndView goToUpdateMinMax() {
		ModelAndView mv = new ModelAndView();
		try {
			if (check(token)) {
				System.out.println("if token");
//				System.out.println(plantFeign.getAllReorderRules().getBody());
				ResponseEntity<List<ReorderRules>> rulesResponse = plantFeign.getAllReorderRules();
				List<ReorderRules> rules = rulesResponse.getBody();
				
				mv.addObject("Reorder", rules);

				mv.setViewName("updateMinMaxQuantities");
			}
			else {
				mv.addObject("error", "Invalid Credentials/Timeout");
				mv.setViewName("login");
			}
			return mv;
		} catch (Exception e) {
			// TODO: handle exception
			mv.addObject("error", e.getMessage());
			mv.addObject("errorMsg", e.getStackTrace().toString());
			mv.setViewName("plantpage");
			return mv;
		}
	}

	@RequestMapping(value = "/RFQ")
	public ModelAndView goToRFQ() {

		ModelAndView mv = new ModelAndView();
		System.out.println(token);
		try {
			if (check(token)) {
				log.trace("Welcome to RFQ page");
				System.out.println("RFQ page");
				mv.setViewName("RFQ");
			}
			else {
				mv.addObject("error", "Invalid Credentials/Timeout");
				mv.setViewName("login");
			}
			return mv;
		} catch (Exception e) {
			// TODO: handle exception
			mv.addObject("error", e.getMessage());
			mv.addObject("errorMsg", e.getStackTrace().toString());
			mv.setViewName("home");
			return mv;
		}
	}

	@PostMapping("/addSupplier")
	@ModelAttribute("supplierPartDTO")
	public ModelAndView addsupplier(HttpServletRequest request) throws ParseException {
		ModelAndView modelAndView = new ModelAndView();
		try {
			if (check(token)) {
				log.trace("Adding supplier and supplier parts");

				//convert http request to supplierpart
				String supplierName = request.getParameter("name");
				String email = request.getParameter("email");
				String phone = request.getParameter("phone");
				String location = request.getParameter("location");
				int feedback = Integer.parseInt(request.getParameter("feedback"));
				long partId = Long.parseLong(request.getParameter("partId"));
				String name = request.getParameter("partName");
				int quantity = Integer.parseInt(request.getParameter("quantity"));
				int timePeriod = Integer.parseInt(request.getParameter("timePeriod"));
				SupplierPartDTO supplierPartDTO = fabricateService
						.createSupplierPartDTO(supplierName,email,phone,location, feedback, partId, name, quantity, timePeriod);
				fabricateService.addsupplier(supplierPartDTO);
				modelAndView = goToSupplier();
				log.trace("Supplier and parts added sucessfully");
			}
			else {
				modelAndView.addObject("error", "Invalid Credentials/Timeout");
				modelAndView.setViewName("login");
			}
			return modelAndView;
		} catch (Exception e) {
			// TODO: handle exception
			modelAndView.addObject("error", e.getMessage());
			modelAndView.addObject("errorMsg", e.getStackTrace().toString());
			modelAndView.setViewName("supplierpage");
			return modelAndView;
		}
	}

	@GetMapping("/ep")
	@ModelAttribute("supplierDTO")
	public ModelAndView editById(HttpServletRequest request) throws ParseException {
		ModelAndView mView = new ModelAndView();
		try {
			SupplierDTO supplier = new SupplierDTO();
			Long id = Long.parseLong(request.getParameter("sid"));
			int sfeedback = Integer.parseInt(request.getParameter("sfeedback"));
			supplier.setId(id);
			supplier.setFeedback(sfeedback);
			if ("Edit Supplier".equals(request.getParameter("submit"))) {
				log.trace("Editing Supplier");
				mView.setViewName("editSupplier");
				Long supplierId = Long.parseLong(request.getParameter("sid"));
				String sname = request.getParameter("sname");
				String slocation = request.getParameter("slocation");
				String email = request.getParameter("email");
				String phone = request.getParameter("phone");
				int feedback = Integer.parseInt(request.getParameter("sfeedback"));

				// Date expectedsupplydate=new //

				supplier.setId(supplierId);
				supplier.setName(sname);
				supplier.setLocation(slocation);
				supplier.setEmail(email);
				supplier.setPhone(phone);
				supplier.setFeedback(feedback);

				mView.addObject("i", supplier);
			} else {
				log.trace("Editing supplier feedback");
				mView.addObject("supplier", supplier);
				mView.setViewName("updateFeedback");

			}
			return mView;
		}catch(Exception ex) {
			mView.addObject("error", ex.getMessage());
			mView.addObject("errorMsg", ex.getStackTrace().toString());
			mView.setViewName("supplierpage");
			return mView;
		}
	}

	@PostMapping("/editSupplier")
	public ModelAndView editSupplierAndParts(HttpServletRequest request) {
		ModelAndView modelAndView = new ModelAndView();
		try {
			if (check(token)) {
				Long id = Long.parseLong(request.getParameter("sid"));
				String sname = request.getParameter("sname");
				String email = request.getParameter("email");
				String phone = request.getParameter("phone");
				String slocation = request.getParameter("slocation");
				int sfeedback = Integer.parseInt(request.getParameter("sfeedback"));

				SupplierDTO supplier = new SupplierDTO();
				supplier.setId(id);
				supplier.setEmail(email);
				supplier.setLocation(slocation);
				supplier.setName(sname);
				supplier.setPhone(phone);
				supplier.setFeedback(sfeedback);

				fabricateService.editsupplier(supplier);

				modelAndView = goToSupplier();
				log.trace("Supplier and parts are edited");
			}
			else {
				modelAndView.addObject("error", "Invalid Credentials/Timeout");
				modelAndView.setViewName("login");
			}
			return modelAndView;
		} catch (Exception ex) {
			modelAndView.addObject("error", ex.getMessage());
			modelAndView.addObject("errorMsg", ex.getStackTrace().toString());
			modelAndView.setViewName("supplierpage");
			return modelAndView;
		}

	}

	@PostMapping("/updateFeedback")
	public ModelAndView updateFeedback(HttpServletRequest request) {
		ModelAndView modelAndView = new ModelAndView();
		try {
			if (check(token)) {
				Long id = Long.parseLong(request.getParameter("sid"));
				int sfeedback = Integer.parseInt(request.getParameter("sfeedback"));
				SupplierDTO supplier = new SupplierDTO();
				supplier.setId(id);
				supplier.setFeedback(sfeedback);
				fabricateService.updateFeedback(supplier);
				modelAndView = goToSupplier();
				log.trace("Feedback updated!!!!!!");
			}
			else {
				modelAndView.addObject("error", "Invalid Credentials/Timeout");
				modelAndView.setViewName("login");
			}
			return modelAndView;
		} catch (Exception ex) {
			modelAndView.addObject("error", ex.getMessage());
			modelAndView.addObject("errorMsg", ex.getStackTrace().toString());
			modelAndView.setViewName("supplierpage");
			return modelAndView;
		}
	}

	@GetMapping("/supplier")
	public ModelAndView goToSupplier() {
		ModelAndView modelAndView = new ModelAndView();
		try {
			if (check(token)) {
				log.info("Welcome to Supplier Page");
				List<SupplierDTO> suppliersList = fabricateService.getAll();
				modelAndView.setViewName("supplierpage");
				modelAndView.addObject("supplierList", suppliersList);
			}
			else {
				modelAndView.addObject("error", "Invalid Credentials/Timeout");
				modelAndView.setViewName("login");
			}
			return modelAndView;
		} catch (Exception ex) {
			modelAndView.addObject("error", ex.getMessage());
			modelAndView.addObject("errorMsg", ex.getStackTrace().toString());
			modelAndView.setViewName("home");
			return modelAndView;
		}
	}

	@GetMapping("/viewStockInHand")
	public ModelAndView viewStockInHands(@RequestParam("partid") Integer partid) {
		ModelAndView modelAndView = new ModelAndView();
		try {
			if (check(token)) {
				log.trace("View part reorder");
				ResponseEntity<Part> partResponse = plantFeign.viewStockInHand(partid);
				Part part= partResponse.getBody();
				//System.out.println(part.toString());
				if(part == null) {
					modelAndView.addObject("error", "PART NOT FOUND");
					modelAndView.setViewName("plantpage");
					return modelAndView;
				}
				modelAndView.setViewName("viewStockInHand");
				modelAndView.addObject("stocks", part);
			} else {
				modelAndView.addObject("error", "Invalid Credentials/Timeout");
				modelAndView.setViewName("login");
			}
			return modelAndView;
		}catch (Exception ex) {
			System.out.println(ex.getMessage());
			modelAndView.addObject("error", ex.getMessage());
			modelAndView.addObject("errorMsg", ex.getStackTrace().toString());
			modelAndView.setViewName("plantpage");
			return modelAndView;
		}
	}

	@GetMapping("/viewPartsReOrder")
	public ModelAndView viewPartReorderDetails() {
		ModelAndView modelAndView = new ModelAndView();
		try {
			if (check(token)) {
				log.trace("View part reorder");
				ResponseEntity<List<PlantReorderDetails>> reorderResponse = plantFeign.viewPartsReorder();
				List<PlantReorderDetails> plant_Reorder_Details= reorderResponse.getBody();
				if(plant_Reorder_Details == null || plant_Reorder_Details.isEmpty()) {
					modelAndView.addObject("error", "NO RE-ORDER REQUIRED");
					modelAndView.setViewName("plantpage");
					return modelAndView;
				}
				modelAndView.setViewName("viewPartsReOrder");
				modelAndView.addObject("partsReorder", plant_Reorder_Details);
			}
			else {
				modelAndView.addObject("error", "Invalid Credentials/Timeout");
				modelAndView.setViewName("login");
			}
			return modelAndView;
		} catch (Exception ex) {
			modelAndView.addObject("error", ex.getMessage());
			modelAndView.addObject("errorMsg", ex.getStackTrace().toString());
			modelAndView.setViewName("plantpage");
			return modelAndView;
		}
	}

	@PostMapping("/updateMinMaxQuantities")
	public ModelAndView updateMinmaxQuantities(HttpServletRequest request) {
		ModelAndView modelAndView = new ModelAndView();
		try {
			if (check(token)) {
				System.out.println("fab controller");
				log.trace("Updating Minimum and Maximum quantities");
				int partId = Integer.parseInt(request.getParameter("partid"));
				int demandId = Integer.parseInt(request.getParameter("demandid"));
				int minQuantity = Integer.parseInt(request.getParameter("min"));
				int maxQuantity = Integer.parseInt(request.getParameter("max"));
				int reorderFrequency = Integer.parseInt(request.getParameter("freq"));
				if(partId < 1 || demandId < 1 || minQuantity < 0 || maxQuantity < 0 || reorderFrequency < 0) {
					modelAndView.addObject("error", "Invalid input provided");
					modelAndView.setViewName("plantpage");
					return modelAndView;
				}
				ReorderRules reorderRules = new ReorderRules();
				reorderRules.setPartId(partId);
				reorderRules.setDemandId(demandId);
				reorderRules.setMinQuantity(minQuantity);
				reorderRules.setMaxQuantity(maxQuantity);
				reorderRules.setReorderFrequency(reorderFrequency);
				ResponseEntity<String> updateResult = plantFeign.updateMinMaxQuantities(reorderRules);
				modelAndView = goToUpdateMinMax();
				modelAndView.addObject("error", updateResult.getBody());
				log.info("Minimum and Maximum quantities updated");
			}
			else {
				modelAndView.addObject("error", "Invalid Credentials/Timeout");
				modelAndView.setViewName("login");
			}
			return modelAndView;
		} catch (Exception ex) {
			modelAndView.addObject("error", ex.getMessage());
			modelAndView.addObject("errorMsg", ex.getStackTrace().toString());
			modelAndView.setViewName("plantpage");
			return modelAndView;
		}
	}

	// RFQ

	@GetMapping("/getRFQOfPlant")
	public ModelAndView getRfqOfPlant(@RequestParam("plantid") Long plantId) {
		ModelAndView modelAndView = new ModelAndView();
		try {
			if (check(token)) {
				log.trace("Getting RFQ of the plant");
				List<RfqDetail> rfq = fabricateService.getRfqOfPlant(plantId);
				if(rfq == null || rfq.isEmpty()) {
					modelAndView.addObject("error", "CAN'T FIND PLANT WITH ID = " + plantId);
					modelAndView.setViewName("RFQ");
					return modelAndView;
				}
				modelAndView.addObject("rfq", rfq);
				modelAndView.setViewName("getRFQOfPlant");
			}
			else {
				modelAndView.addObject("error", "Invalid Credentials/Timeout");
				modelAndView.setViewName("login");
			}
			return modelAndView;
		}catch (Exception ex) {
			modelAndView.addObject("error", "Supplier not created or can't be located");
			//modelAndView.addObject("error", ex.getMessage());
			modelAndView.addObject("errorMsg", ex.getStackTrace().toString());
			modelAndView.setViewName("RFQ");
			return modelAndView;
		}
	}

	@GetMapping("/getPotentialVendorsOfRFQ")
	public ModelAndView getPotentialVendorsOfRFQ(HttpServletRequest request) {
		ModelAndView modelAndView = new ModelAndView();
		try {
			if (check(token)) {
				log.trace("Checking token");
				Long rfqId = Long.parseLong(request.getParameter("rfqid"));
				ResponseEntity<List<SupplierDTO>> supplierList = fabricateService.getPotentialVendorsOfRFQ(rfqId);
				List<SupplierDTO> supplierList1 = supplierList.getBody();
				if(supplierList1 == null || supplierList1.isEmpty()) {
					modelAndView.addObject("error", "NO POTENTIAL SUPPLIERS AVAILABLE");
					modelAndView.setViewName("RFQ");
					return modelAndView;
				}
				modelAndView.setViewName("getPotentialVendorsOfRFQ");
				modelAndView.addObject("supplierParts", supplierList1);
			}
			else {
				modelAndView.addObject("error", "Invalid Credentials/Timeout");
				modelAndView.setViewName("login");
			}
			return modelAndView;
		} catch (Exception ex) {
			modelAndView.addObject("error", "RFQ ID NOT FOUND");
			//modelAndView.addObject("error", ex.getMessage());
			modelAndView.addObject("errorMsg", ex.getStackTrace().toString());
			modelAndView.setViewName("RFQ");
			return modelAndView;
		}
	}

}
