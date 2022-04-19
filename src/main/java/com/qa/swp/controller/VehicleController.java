package com.qa.swp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.qa.swp.domain.Vehicle;
import com.qa.swp.service.VehicleService;

@RestController
public class VehicleController {
	
	private VehicleService service;
	
	@Autowired
	public VehicleController(VehicleService service) {
		super();
		this.service = service;
	}
	
	// CREATE
	@PostMapping("/create") // 201 - CREATED
	public ResponseEntity<Vehicle> createVehicle(@RequestBody Vehicle v) {
		Vehicle created = this.service.create(v);
		ResponseEntity<Vehicle> response = new ResponseEntity<Vehicle>(created, HttpStatus.CREATED);
		return response;
	}
	
	// READ ALL
	@GetMapping("/getAll") // 200 - OK
	public ResponseEntity<List<Vehicle>> getAllMotors() {
		return ResponseEntity.ok(this.service.getAll());
	}
		
	// READ ONE
	@GetMapping("/get/{id}") // 200 - OK
	public Vehicle getVehicle(@PathVariable Integer id) {
		return this.service.getOne(id);
	}
		
	// UPDATE
	@PutMapping("/replace/{id}") // 202 - ACCEPTED
	public ResponseEntity<Vehicle> replaceVehicle(@PathVariable Integer id, @RequestBody Vehicle newVehicle) {
		Vehicle body = this.service.replace(id, newVehicle);
		ResponseEntity<Vehicle> response = new ResponseEntity<Vehicle>(body, HttpStatus.ACCEPTED);
		return response;
	}
		
	// DELETE
	@DeleteMapping("/remove/{id}") // 204 - NO CONTENT
	public ResponseEntity<?> removeDog(@PathVariable Integer id) {
		this.service.remove(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
	// READ BY NAME
	@GetMapping("/getByRegistration/{registration}") // 200 - OK
	public ResponseEntity<List<Vehicle>> getVehicleByRegistration(@PathVariable String registration) {
		List<Vehicle> found = this.service.getMotorsByRegistration(registration);
		return ResponseEntity.ok(found);
	}
		
	// READ BY AGE
	@GetMapping("/getByType/{type}") // 200 - OK
	public ResponseEntity<List<Vehicle>> getVehicleByType(@PathVariable String type) {
		List<Vehicle> found = this.service.getMotorsByType(type);
		return ResponseEntity.ok(found);
	}
	
	// READ BY WEIGHT
	@GetMapping("/getByJob/{job}") // 200 - OK
	public ResponseEntity<List<Vehicle>> getVehicleByJob(@PathVariable String job) {
		List<Vehicle> found = this.service.getMotorsByJob(job);
		return ResponseEntity.ok(found);
	}
}
