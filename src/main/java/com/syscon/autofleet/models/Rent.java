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
@Table(name="rents")
public class Rent extends BaseEntity implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@Column(nullable = false)
	private Integer vehicle_id;
	
	@Column(nullable = false)
	private Integer user_id;
	
	@CreationTimestamp
    private Timestamp rent_date;
	
	@CreationTimestamp
    private Timestamp return_date;
	
	@Column(nullable = false)
	private Double price;
	
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

	public Timestamp getRent_date() {
		return rent_date;
	}

	public Timestamp getReturn_date() {
		return return_date;
	}

	public Double getPrice() {
		return price;
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

	public void setRent_date(Timestamp rent_date) {
		this.rent_date = rent_date;
	}

	public void setReturn_date(Timestamp return_date) {
		this.return_date = return_date;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public void setReturned_at(Timestamp returned_at) {
		this.returned_at = returned_at;
	}
}
