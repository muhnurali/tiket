package com.lawencon.tiket.service;

import java.util.List;
import com.lawencon.tiket.model.Customer;

public interface CustomerService {
	abstract String tambahCustomer(Customer customer, String username, String password) throws Exception;
	abstract List<Customer> tampilCustomer(String username, String password) throws Exception;
	abstract String ubahCustomer(Customer customer, String username, String password) throws Exception;
	abstract String hapusCustomer(Integer id, String username, String password) throws Exception;
	abstract void cekCustomer(String username, String password) throws Exception;

}
