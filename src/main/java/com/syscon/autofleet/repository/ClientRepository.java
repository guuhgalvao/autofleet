package com.syscon.autofleet.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.syscon.autofleet.models.Client;

public interface ClientRepository extends JpaRepository<Client, Integer> {
	Client findByCnpj(String cnpj);
}
