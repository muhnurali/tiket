package com.lawencon.tiket.service;

import java.util.List;
import com.lawencon.tiket.model.Customer;

public interface CustomerService {
	abstract String tambahCustomer(Customer customer) throws Exception;
	abstract List<Customer> tampilCustomer() throws Exception;
	abstract String ubahCustomer(Customer customer) throws Exception;
	abstract String hapusCustomer(Customer customer) throws Exception;
}
