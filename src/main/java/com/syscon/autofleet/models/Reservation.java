package com.syscon.autofleet.models;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

@Entity
@Table(name="reservations")
public class Reservation extends BaseEntity implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@Column(nullable = false)
	private Integer vehicle_id;
	
	@Column(nullable = false)
	private Integer user_id;
	
	@CreationTimestamp
    private Timestamp reservation_date;
	
	@CreationTimestamp
    private Timestamp return_date;
	
	@Column(nullable = true)
	@CreationTimestamp
    private Timestamp returned_at;

	// Getters
	public Integer getId() {
		return id;
	}

	public Integer getVehicle_id() {
		return vehicle_id;
	}

	public Integer getUser_id() {
		return user_id;
	}

	public Timestamp getReservation_date() {
		return reservation_date;
	}

	public Timestamp getReturn_date() {
		return return_date;
	}

	public Timestamp getReturned_at() {
		return returned_at;
	}

	// Setters
	public void setId(Integer id) {
		this.id = id;
	}

	public void setVehicle_id(Integer vehicle_id) {
		this.vehicle_id = vehicle_id;
	}

	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}

	public void setReservation_date(Timestamp reservation_date) {
		this.reservation_date = reservation_date;
	}

	public void setReturn_date(Timestamp return_date) {
		this.return_date = return_date;
	}

	public void setReturned_at(Timestamp returned_at) {
		this.returned_at = returned_at;
	}
}
