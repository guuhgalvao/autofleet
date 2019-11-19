package com.syscon.autofleet.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.syscon.autofleet.models.User;

@Repository
@Transactional
public interface UserRepository extends JpaRepository<User, Integer> {
	
	User findByEmail(String email);
}
