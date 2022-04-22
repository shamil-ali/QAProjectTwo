package com.qa.swp.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.Sql.ExecutionPhase;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultMatcher;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.qa.swp.domain.Vehicle;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc // Sets up theMockMvc object
@Sql(scripts = {"classpath:vehicle-schema.sql", "classpath:vehicle-data.sql"}, executionPhase = ExecutionPhase.BEFORE_TEST_METHOD)
@ActiveProfiles("test")
public class VehicleControllerIntegrationTest {
		
	@Autowired // Pull the MockMvc object from the context
	private MockMvc mvc; // Class that performs the request (Similar to Postman)
	
	@Autowired
	private ObjectMapper mapper; // Java <-> JSON Converter that Spring uses

	@Test // CREATE
	void testCreate() throws Exception {
		Vehicle testVehicle = new Vehicle(null, "Car", "ABC123", "MOT");
		testVehicle.setId(null);
		String testVehicleAsJSON = this.mapper.writeValueAsString(testVehicle);
		RequestBuilder req = post("/create").contentType(MediaType.APPLICATION_JSON).content(testVehicleAsJSON);
		
		Vehicle testCreatedVehicle = new Vehicle(3, "Car", "ABC123", "MOT");
		String testCreatedVehicleAsJSON = this.mapper.writeValueAsString(testCreatedVehicle);
		
		ResultMatcher checkStatus = status().isCreated();
		ResultMatcher checkBody = content().json(testCreatedVehicleAsJSON);
		
		this.mvc.perform(req).andExpect(checkStatus).andExpect(checkBody);		
	}
	
	@Test // GET ALL
	void testGetAll() throws Exception {
		RequestBuilder req = get("/getAll");
		
		List<Vehicle> testMotors = List.of(new Vehicle(1, "ABC123", "Car", "MOT"), new Vehicle(2,"XYZ789", "Bike", "Service"));
		String testMotorsAsJSON = this.mapper.writeValueAsString(testMotors);
		
		ResultMatcher checkStatus = status().isOk();
		ResultMatcher checkBody = content().json(testMotorsAsJSON);
		
		this.mvc.perform(req).andExpect(checkStatus).andExpect(checkBody);
	}
	
	@Test // GET ONE
	void testGetOne() throws Exception {
		RequestBuilder req = get("/get/1");
		
		String testGetOneAsJSON = this.mapper.writeValueAsString(new Vehicle(1, "ABC123", "Car", "MOT"));
		
		ResultMatcher checkStatus = status().isOk();
		ResultMatcher checkBody = content().json(testGetOneAsJSON);
		
		this.mvc.perform(req).andExpect(checkStatus).andExpect(checkBody);
	}
	
	@Test // REPLACE
	void testReplace() throws Exception {
		Vehicle testVehicle = new Vehicle(null, "XXX999", "Plane", "Oil Leak");
		String testVehicleAsJSON = this.mapper.writeValueAsString(testVehicle);
		RequestBuilder req = put("/replace/1").contentType(MediaType.APPLICATION_JSON).content(testVehicleAsJSON);
		
		Vehicle testUpdatedVehicle = new Vehicle(1, "XXX999", "Plane", "Oil Leak");
		String testUpdatedVehicleAsJSON = this.mapper.writeValueAsString(testUpdatedVehicle);
		
		ResultMatcher checkStatus = status().isAccepted();
		ResultMatcher checkBody = content().json(testUpdatedVehicleAsJSON);
		
		this.mvc.perform(req).andExpect(checkStatus).andExpect(checkBody);
	}
	
	@Test // REMOVE
	void testRemove() throws Exception {
		this.mvc.perform(delete("/remove/1")).andExpect(status().isNoContent());	
	}
	
	@Test // GET BY NAME
	void testGetByRegistration() throws Exception {
		RequestBuilder req = get("/getByRegistration/ABC123");
		
		List<Vehicle> testVehicleByRegistration = List.of(new Vehicle(1, "ABC123", "Car", "MOT"));
		String testVehicleByRegistrationAsJSON = this.mapper.writeValueAsString(testVehicleByRegistration);
		
		ResultMatcher checkStatus = status().isOk();
		ResultMatcher checkBody = content().json(testVehicleByRegistrationAsJSON);
		
		this.mvc.perform(req).andExpect(checkStatus).andExpect(checkBody);
	}
	
	@Test // GET BY AGE
	void testGetByType() throws Exception {
		RequestBuilder req = get("/getByType/Car");
		
		List<Vehicle> testVehicleByType = List.of(new Vehicle(1, "ABC123", "Car", "MOT"));
		String testVehicleByTypeAsJSON = this.mapper.writeValueAsString(testVehicleByType);
		
		ResultMatcher checkStatus = status().isOk();
		ResultMatcher checkBody = content().json(testVehicleByTypeAsJSON);
		
		this.mvc.perform(req).andExpect(checkStatus).andExpect(checkBody);
	}
	
	@Test // GET BY WEIGHT
	void testGetByJob() throws Exception {
		RequestBuilder req = get("/getByJob/MOT");
		
		List<Vehicle> testVehicleByJob = List.of(new Vehicle(1, "ABC123", "Car", "MOT"));
		String testVehicleByJobAsJSON = this.mapper.writeValueAsString(testVehicleByJob);
		
		ResultMatcher checkStatus = status().isOk();
		ResultMatcher checkBody = content().json(testVehicleByJobAsJSON);
		
		this.mvc.perform(req).andExpect(checkStatus).andExpect(checkBody);
	}
}

