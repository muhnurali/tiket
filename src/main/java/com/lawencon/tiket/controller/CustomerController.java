package com.lawencon.tiket.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;
import com.lawencon.tiket.model.Customer;
import com.lawencon.tiket.service.CustomerService;

@SuppressWarnings("rawtypes")
@RestController
public class CustomerController extends BaseController {
	
	//YWRtaW46YWRtaW4=
	@Autowired
	CustomerService customerService;
	
	Customer customer = new Customer();
	List<Customer> listCustomers = new ArrayList<>();
	
	@SuppressWarnings("unchecked")
	@PostMapping("/customer")
	public ResponseEntity<String> tambahCustomer(@RequestBody String content, @RequestHeader("Authorization") String authorization) throws Exception {
		String[] auth = super.authUser(authorization);
		try {
			customer = (Customer) super.readValue(content, Customer.class);
			return new ResponseEntity<>(customerService.tambahCustomer(customer, auth[0], auth[1]), HttpStatus.ACCEPTED);
		} catch (Exception e) {
			return new ResponseEntity<>("Gagal Tambah Customer",HttpStatus.BAD_GATEWAY);
		}
	}	

	@GetMapping("/customer")
	public ResponseEntity<List<Customer>> tampilCustomer(@RequestHeader("Authorization") String authorization) {
		String[] auth = super.authUser(authorization);
		try {
			listCustomers = customerService.tampilCustomer(auth[0], auth[1]);
			return new ResponseEntity<>(listCustomers, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(listCustomers, HttpStatus.BAD_REQUEST);
		}
	}

	@SuppressWarnings("unchecked")
	@PutMapping("/customer")
	public ResponseEntity<String> ubahCustomer(@RequestBody String content, @RequestHeader("Authorization") String authorization) throws Exception {
		String[] auth = super.authUser(authorization);
		try {
			customer = (Customer) super.readValue(content, Customer.class);
			return new ResponseEntity<>(customerService.ubahCustomer(customer, auth[0], auth[1]), HttpStatus.ACCEPTED);
		} catch (Exception e) {
			return new ResponseEntity<>("Gagal Update Customer", HttpStatus.BAD_GATEWAY);
		}
	}

	@DeleteMapping("/customer/{id}")
	public ResponseEntity<String> hapusCustomer(@PathVariable("id") Integer id, @RequestHeader("Authorization") String authorization) throws Exception {
		String[] auth = super.authUser(authorization);
		try {
			customerService.hapusCustomer(id, auth[0], auth[1]);
			return new ResponseEntity<>("Berhasil Hapus Customer", HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>("Gagal Hapus Customer", HttpStatus.BAD_REQUEST);
		}
	}

}
