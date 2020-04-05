package com.lawencon.tiket.dao.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lawencon.tiket.model.Customer;

public interface CustomerRevo extends JpaRepository<Customer, Integer>{
	abstract Customer findByUsernameAndPassword(String username, String password);
}
