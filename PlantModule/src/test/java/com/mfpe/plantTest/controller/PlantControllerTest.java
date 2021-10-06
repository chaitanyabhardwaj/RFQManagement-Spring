package com.mfpe.plantTest.controller;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.mfpe.plant.PlantApplication;
import com.mfpe.plant.controller.PlantController;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = { PlantApplication.class })
@AutoConfigureMockMvc
public class PlantControllerTest {

	@Autowired
	private MockMvc mockMvc;

//	@Autowired
//	private WebApplicationContext wc;

	@Before
	public void setup() {
		this.mockMvc = MockMvcBuilders.standaloneSetup(new PlantController()).build();
	}

	@Test
	public void viewPartsReOrderTest() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/viewPartsReOrder").accept(MediaType.APPLICATION_JSON))
				.andExpect(status().is(200));
	}

	@Test
	public void viewStockInHandTest() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/viewStockInHand/{id}", 1).accept(MediaType.APPLICATION_JSON))
				.andExpect(status().is(200));
	}
	
	@Test
	public void getReorderRulesTest() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/getReorderRules").accept(MediaType.APPLICATION_JSON))
				.andExpect(status().is(200));
	}
	
	@Test
	public void getPartByIdTest() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/getPartById/1").accept(MediaType.APPLICATION_JSON))
				.andExpect(status().is(200));
	}
}
