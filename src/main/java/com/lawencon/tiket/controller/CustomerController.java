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
import com.fasterxml.jackson.databind.ObjectMapper;
import com.lawencon.tiket.model.Customer;
import com.lawencon.tiket.service.CustomerService;

@RestController
public class CustomerController extends BaseController {
	
	//YWRtaW46YWRtaW4=
	@Autowired
	CustomerService customerService;
	
	@PostMapping("/customer")
	public ResponseEntity<String> tambahCustomer(@RequestBody String content, @RequestHeader("Authorization") String authorization) throws Exception {
		Customer customer = new Customer();
		String[] auth = super.authUser(authorization);
		try {
			customer = new ObjectMapper().readValue(content, Customer.class);
			customerService.tambahCustomer(customer, auth[0], auth[1]);
		} catch (Exception e) {
			return new ResponseEntity<>("Gagal Tambah Customer",HttpStatus.BAD_GATEWAY);
		}
		return new ResponseEntity<>(customerService.tambahCustomer(customer, auth[0], auth[1]), HttpStatus.ACCEPTED);
	}	

	@GetMapping("/customer")
	public ResponseEntity<List<Customer>> tampilCustomer(@RequestHeader("Authorization") String authorization) {
		List<Customer> listCustomers = new ArrayList<>();
		String[] auth = super.authUser(authorization);
		try {
			listCustomers = customerService.tampilCustomer(auth[0], auth[1]);
		} catch (Exception e) {
			return new ResponseEntity<>(listCustomers, HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<>(listCustomers, HttpStatus.OK);
	}

	@PutMapping("/customer")
	public ResponseEntity<String> ubahCustomer(@RequestBody String content, @RequestHeader("Authorization") String authorization) throws Exception {
		Customer customer = new Customer();
		String[] auth = super.authUser(authorization);
		try {
			customer = new ObjectMapper().readValue(content, Customer.class);
			customerService.ubahCustomer(customer, auth[0], auth[1]);
		} catch (Exception e) {
			return new ResponseEntity<>("Gagal Update Customer", HttpStatus.BAD_GATEWAY);
		}
		return new ResponseEntity<>(customerService.ubahCustomer(customer, auth[0], auth[1]), HttpStatus.ACCEPTED);
	}

	@DeleteMapping("/customer/{id}")
	public ResponseEntity<String> hapusCustomer(@PathVariable("id") Integer id, @RequestHeader("Authorization") String authorization) throws Exception {
		String[] auth = super.authUser(authorization);
		try {
			customerService.hapusCustomer(id, auth[0], auth[1]);
		} catch (Exception e) {
			return new ResponseEntity<>("Gagal Hapus Customer", HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<>("Berhasil Hapus Customer", HttpStatus.OK);
	}


}
