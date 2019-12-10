package com.syscon.autofleet.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="users")
public class User extends BaseEntity implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@Column(length = 100, nullable = false)
	private String name;
	
	@Column(length = 150, nullable = false, unique = true)
	private String email;
	
	@Column(length = 15, nullable = false)
	private String phone;
	
	@Column(nullable = false)
	private String password;
	
	@Column(nullable = true)
	private String token;
	
	@Column(nullable = false, length = 50)
	private String type;
	
	@Column(nullable = true)
	private Integer client_id;
	
	@Column(length = 14, nullable = true)
	private String cpf;
	
	@Column(length = 11, nullable = true)
	private String cnh;
	
	// Getters
	public Integer getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}
	
	public String getEmail() {
		return email;
	}
	
	public String getPhone() {
		return phone;
	}
	
	public String getPassword() {
		return password;
	}
	
	public String getToken() {
		return token;
	}
	
	public String getType() {
		return type;
	}
	
	public Integer getClient_id() {
		return client_id;
	}
	
	public String getCpf() {
		return cpf;
	}
	
	public String getCnh() {
		return cnh;
	}
	
	// Setters
	public void setId(Integer id) {
		this.id = id;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public void setToken(String token) {
		this.token = token;
	}
	
	public void setType(String type) {
		this.type = type;
	}
	
	public void setClient_id(Integer client_id) {
		this.client_id = client_id;
	}
	
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	public void setCnh(String cnh) {
		this.cnh = cnh;
	}
}
