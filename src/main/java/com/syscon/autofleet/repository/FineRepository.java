package com.syscon.autofleet.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.syscon.autofleet.models.Fine;

public interface FineRepository extends JpaRepository<Fine, Integer> {
	
//	Fine findAllByVehicleId(Integer vehicle_id);
//	Fine findAllByUserId(Integer user_id);
}
