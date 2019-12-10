package com.syscon.autofleet.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.syscon.autofleet.models.Rent;

public interface RentRepository extends JpaRepository<Rent, Integer> {

}
