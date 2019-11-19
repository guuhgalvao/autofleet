package com.syscon.autofleet.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="clients")
public class Client extends BaseEntity implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@Column(length = 100, nullable = false)
	private String name;
	
	@Column(length = 18, nullable = false, unique = true)
	private String cnpj;
	
	@Column(length = 150, nullable = false)
	private String address;
	
	@Column(nullable = false)
	private Integer number;
	
	@Column(length = 50, nullable = true)
	private String complement;
	
	@Column(length = 100, nullable = false)
	private String district;
	
	@Column(length = 100, nullable = false)
	private String city;
	
	@Column(length = 2, nullable = false)
	private String state;

	// Getters
	public Integer getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getCnpj() {
		return cnpj;
	}

	public String getAddress() {
		return address;
	}

	public Integer getNumber() {
		return number;
	}

	public String getComplement() {
		return complement;
	}

	public String getDistrict() {
		return district;
	}

	public String getCity() {
		return city;
	}

	public String getState() {
		return state;
	}

	// Setters
	public void setId(Integer id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public void setComplement(String complement) {
		this.complement = complement;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public void setState(String state) {
		this.state = state;
	}
}
