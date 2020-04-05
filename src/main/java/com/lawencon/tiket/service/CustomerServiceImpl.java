package com.lawencon.tiket.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.lawencon.tiket.dao.CustomerDao;
import com.lawencon.tiket.model.Customer;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	@Qualifier("customer_hibernate")
	CustomerDao customerDao;
	
	@Override
	public String tambahCustomer(Customer customer, String username, String password) throws Exception {
		customerDao.cekCustomer(username, password);
		customerDao.tambahCustomer(customer);
		return "Berhasil Tambah Customer";
	}

	@Override
	public List<Customer> tampilCustomer(String username, String password) throws Exception {
		customerDao.cekCustomer(username, password);
		return customerDao.tampilCustomer();
	}

	@Override
	public String ubahCustomer(Customer customer, String username, String password) throws Exception {
		customerDao.cekCustomer(username, password);
		customerDao.ubahCustomer(customer);
		return "Berhasil Ubah Customer";
	}

	@Override
	public String hapusCustomer(Integer id, String username, String password) throws Exception {
		customerDao.cekCustomer(username, password);
		customerDao.hapusCustomer(id);
		return "Berhasil Hapus Customer";
	}

	@Override
	public void cekCustomer(String username, String password) throws Exception {
		Customer customer = customerDao.cekCustomer(username, password);
		if (!customer.getUsername().equals(username) && !customer.getPassword().equals(password)) {
			throw new Exception();
		}
	}

}
