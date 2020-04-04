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
	public String tambahCustomer(Customer customer) throws Exception {
		customerDao.tambahCustomer(customer);
		return "Berhasil Tambah Customer";
	}

	@Override
	public List<Customer> tampilCustomer() throws Exception {
		return customerDao.tampilCustomer();
	}

	@Override
	public String ubahCustomer(Customer customer) throws Exception {
		customerDao.ubahCustomer(customer);
		return "Berhasil Ubah Customer";
	}

	@Override
	public String hapusCustomer(Customer customer) throws Exception {
		customerDao.hapusCustomer(customer);
		return "Berhasil Hapus Customer";
	}

}
