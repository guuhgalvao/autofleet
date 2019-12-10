package com.syscon.autofleet.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="vehicles")
public class Vehicle extends BaseEntity implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@Column(length = 8, nullable = false, unique = true)
	private String plate;
	
	@Column(length = 50, nullable = false)
	private String brand;
	
	@Column(length = 50, nullable = false)
	private String model;
	
	@Column(length = 50, nullable = false)
	private String color;
	
	@Column(nullable = false)
	private Integer year;
	
	@Column(nullable = false)
	private Double mileage;
	
	@Column(nullable = false)
	private Integer status;
	
	@Column(nullable = false)
	private Integer type;
	
	@Column(nullable = true)
	private Integer client_id;
	
	@Column(nullable = true)
	private Double price;
	
	// Getters
	public Integer getId() {
		return id;
	}

	public String getPlate() {
		return plate;
	}

	public String getBrand() {
		return brand;
	}

	public String getModel() {
		return model;
	}

	public String getColor() {
		return color;
	}

	public Integer getYear() {
		return year;
	}

	public Double getMileage() {
		return mileage;
	}

	public Integer getStatus() {
		return status;
	}

	public Integer getType() {
		return type;
	}

	public Integer getClient_id() {
		return client_id;
	}

	public Double getPrice() {
		return price;
	}

	// Setters
	public void setId(Integer id) {
		this.id = id;
	}

	public void setPlate(String plate) {
		this.plate = plate;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public void setYear(Integer year) {
		this.year = year;
	}

	public void setMileage(Double mileage) {
		this.mileage = mileage;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public void setClient_id(Integer client_id) {
		this.client_id = client_id;
	}

	public void setPrice(Double price) {
		this.price = price;
	}
}
