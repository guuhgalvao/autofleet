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
@Table(name="fines")
public class Fine extends BaseEntity implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@Column(nullable = false)
	private Integer vehicle_id;
	
	@Column(nullable = false)
	private Integer user_id;
	
	@CreationTimestamp
    private Timestamp dt_fine;
	
	@Column(nullable = false)
	private Double price;

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

	public Timestamp getDt_fine() {
		return dt_fine;
	}

	public Double getPrice() {
		return price;
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

	public void setDt_fine(Timestamp dt_fine) {
		this.dt_fine = dt_fine;
	}

	public void setPrice(Double price) {
		this.price = price;
	}
	
	
}
