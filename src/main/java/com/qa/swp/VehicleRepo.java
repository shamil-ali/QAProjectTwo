package com.qa.swp;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.qa.swp.domain.Vehicle;

public interface VehicleRepo extends JpaRepository<Vehicle, Integer> {

	List<Vehicle> findByRegistrationIgnoreCase(String registration);

	List<Vehicle> findByType(String type);

	List<Vehicle> findByJob(String job);

}
