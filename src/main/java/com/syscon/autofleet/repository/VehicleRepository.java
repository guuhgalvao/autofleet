package com.syscon.autofleet.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.syscon.autofleet.models.Vehicle;

public interface VehicleRepository extends JpaRepository<Vehicle, Integer> {
	Vehicle findByPlate(String plate);
}
