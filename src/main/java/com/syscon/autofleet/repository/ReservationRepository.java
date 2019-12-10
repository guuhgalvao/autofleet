package com.syscon.autofleet.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.syscon.autofleet.models.Reservation;

public interface ReservationRepository extends JpaRepository<Reservation, Integer> {

}
