package com.qa.swp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.qa.swp.VehicleRepo;
import com.qa.swp.domain.Vehicle;

@Service
public class VehicleService implements ServiceIF<Vehicle> {
	
	private VehicleRepo repo;
	
	@Autowired
	public VehicleService(VehicleRepo repo) {
		super();
		this.repo = repo;
	}
	
	public Vehicle create(Vehicle v) {
		Vehicle created = this.repo.save(v);
		return created;
	}
	
	public List<Vehicle> getAll() {
		return this.repo.findAll();
	}
	
	public Vehicle getOne (Integer id) {
		Optional<Vehicle> found = this.repo.findById(id);
		return found.get();
	}
	
	public Vehicle replace(Integer id, Vehicle newVehicle) {
		Vehicle existing = this.repo.findById(id).get();
		existing.setRegistration(newVehicle.getRegistration());
		existing.setType(newVehicle.getType());
		existing.setJob(newVehicle.getJob());
//		existing.setContactNumber(newVehicle.getContactNumber());
		Vehicle updated = this.repo.save(existing);
		return updated;
	}
	
	public void remove(@PathVariable Integer id) {
		this.repo.deleteById(id);
	}
	
//	public void removeAll() {
//		
//	}
	
	public List<Vehicle> getMotorsByRegistration(String registration) {
		List<Vehicle> found = this.repo.findByRegistrationIgnoreCase(registration);
		return found;
	}
	
	public List<Vehicle> getMotorsByType(String type) {
		List<Vehicle> found = this.repo.findByType(type);
		return found;
	}
	
	public List<Vehicle> getMotorsByJob(String job) {
		List<Vehicle> found = this.repo.findByJob(job);
		return found;
	}

}
