package com.lawencon.tiket.dao;

import java.util.List;
import com.lawencon.tiket.model.Customer;

public interface CustomerDao {
	abstract void tambahCustomer(Customer customer) throws Exception;
	abstract List<Customer> tampilCustomer() throws Exception;
	abstract void ubahCustomer(Customer customer) throws Exception;
	abstract void hapusCustomer(Integer id) throws Exception;
	abstract Customer cekCustomer(String username, String password) throws Exception;
}
