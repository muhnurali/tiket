package com.lawencon.tiket.dao.jpa;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.lawencon.tiket.dao.CustomerDao;
import com.lawencon.tiket.model.Customer;

@Repository("customer_jpa")
public class CustomerDaoImpl implements CustomerDao {

	@Autowired
	CustomerRevo customerRevo;
	
	@Override
	public void tambahCustomer(Customer customer) throws Exception {
		customerRevo.save(customer);
	}

	@Override
	public List<Customer> tampilCustomer() throws Exception {
		return customerRevo.findAll();
	}

	@Override
	public void ubahCustomer(Customer customer) throws Exception {		
		customerRevo.save(customer);
	}

	@Override
	public void hapusCustomer(Integer id) throws Exception {
		customerRevo.deleteById(id);
	}

	@Override
	public Customer cekCustomer(String username, String password) throws Exception {
		return customerRevo.findByUsernameAndPassword(username, password);
	}

}
