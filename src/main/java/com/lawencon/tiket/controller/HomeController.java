package com.lawencon.tiket.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.lawencon.tiket.model.Customer;
import com.lawencon.tiket.model.DetailTransaksiTiket;
import com.lawencon.tiket.model.HeaderDetail;
import com.lawencon.tiket.service.CustomerService;
import com.lawencon.tiket.service.DetailTransaksiTiketService;
import com.lawencon.tiket.service.HeaderTransasksiTiketService;

@RestController
public class HomeController extends BaseController {
	
	//YWRtaW46YWRtaW4=
	@Autowired
	CustomerService customerService;
	
	@Autowired
	HeaderTransasksiTiketService header;
	
	@Autowired
	DetailTransaksiTiketService detail;
	
	@SuppressWarnings("unchecked")
	@PostMapping("/transasksi")
	public ResponseEntity<String> tambahTransaksi(@RequestBody String content,
			@RequestHeader("Authorization") String authorization) throws Exception {
		List<HeaderDetail> d = new ArrayList<>();
		String[] auth = super.authUser(authorization);
		try {
			header.tambahTransaksiHeader(auth[0], auth[1]);
			d = (List<HeaderDetail>) new ObjectMapper().readValue(content, DetailTransaksiTiket.class);
			detail.tambahTransaksiDetail(d, auth[0], auth[1]);
		} catch (Exception e) {
			return new ResponseEntity<>("Gagal Tambah Customer",HttpStatus.BAD_GATEWAY);
		}
		return new ResponseEntity<>("Kela", HttpStatus.ACCEPTED);
	}	
	
	@GetMapping("/transaksi")
	public ResponseEntity<List<DetailTransaksiTiket>> tampilTransaksi() throws Exception {
		List<DetailTransaksiTiket> d = new ArrayList<DetailTransaksiTiket>();
		try {
			d = detail.tampil();
		} catch (Exception e) {
			return new ResponseEntity<>(d,HttpStatus.BAD_GATEWAY);
		}
		return new ResponseEntity<>(d, HttpStatus.ACCEPTED);
	}	
	
	@PostMapping("/customer")
	public ResponseEntity<String> tambahCustomer(@RequestBody String content) throws Exception {
		Customer customer = new Customer();
		try {
			customer = new ObjectMapper().readValue(content, Customer.class);
			customerService.tambahCustomer(customer);
		} catch (Exception e) {
			return new ResponseEntity<>("Gagal Tambah Customer",HttpStatus.BAD_GATEWAY);
		}
		return new ResponseEntity<>(customerService.tambahCustomer(customer), HttpStatus.ACCEPTED);
	}	

	@GetMapping("/customer")
	public ResponseEntity<List<Customer>> tampilCustomer() {
		List<Customer> listCustomers = new ArrayList<>();
		try {
			listCustomers = customerService.tampilCustomer();
		} catch (Exception e) {
			return new ResponseEntity<>(listCustomers, HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<>(listCustomers, HttpStatus.OK);
	}

	@PutMapping("/customer")
	public ResponseEntity<String> ubahCustomer(@RequestBody String content) throws Exception {
		Customer customer = new Customer();
		try {
			customer = new ObjectMapper().readValue(content, Customer.class);
			customerService.ubahCustomer(customer);
		} catch (Exception e) {
			return new ResponseEntity<>("Gagal Update Customer", HttpStatus.BAD_GATEWAY);
		}
		return new ResponseEntity<>(customerService.ubahCustomer(customer), HttpStatus.ACCEPTED);
	}

	//ERROR
	@DeleteMapping("/customer")
	public ResponseEntity<String> hapusCustomer(@RequestBody String content) throws Exception {
		Customer customer = new Customer();
		try {
			customer = new ObjectMapper().readValue(content, Customer.class);
			customerService.hapusCustomer(customer);
		} catch (Exception e) {
			return new ResponseEntity<>("Gagal Hapus Customer", HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<>(customerService.hapusCustomer(customer), HttpStatus.OK);
	}


}
