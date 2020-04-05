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
import com.lawencon.tiket.model.Diskon;
import com.lawencon.tiket.service.DiskonService;

@RestController
public class DiskonController  extends BaseController {

	@Autowired
	DiskonService diskonService;
	
	@PostMapping("/diskon")
	public ResponseEntity<String> tambah(@RequestBody String content, @RequestHeader("Authorization") String authorization) throws Exception {
		Diskon diskon = new Diskon();
		String[] auth = super.authUser(authorization);
		try {
			diskon = new ObjectMapper().readValue(content, Diskon.class);
			diskonService.tambahDiskon(diskon, auth[0], auth[1]);
		} catch (Exception e) {
			return new ResponseEntity<>("Gagal Tambah Diskon",HttpStatus.BAD_GATEWAY);
		}
		return new ResponseEntity<>(diskonService.tambahDiskon(diskon, auth[0], auth[1]), HttpStatus.ACCEPTED);
	}	

	@GetMapping("/diskon")
	public ResponseEntity<?> tampil(@RequestHeader("Authorization") String authorization) {
		List<Diskon> list = new ArrayList<>();
		String[] auth = super.authUser(authorization);
		try {
			list = diskonService.tampilDiskon(auth[0], auth[1]);
		} catch (Exception e) {
			return new ResponseEntity<>("Gagal Menampilkan List Diskon", HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<>(list, HttpStatus.OK);
	}

	@PutMapping("/diskon")
	public ResponseEntity<String> ubah(@RequestBody String content, @RequestHeader("Authorization") String authorization) throws Exception {
		Diskon diskon = new Diskon();
		String[] auth = super.authUser(authorization);
		try {
			diskon = new ObjectMapper().readValue(content, Diskon.class);
			diskonService.ubahDiskon(diskon, auth[0], auth[1]);
		} catch (Exception e) {
			return new ResponseEntity<>("Gagal Update Diskon", HttpStatus.BAD_GATEWAY);
		}
		return new ResponseEntity<>(diskonService.ubahDiskon(diskon, auth[0], auth[1]), HttpStatus.ACCEPTED);
	}

	@DeleteMapping("/diskon/{id}")
	public ResponseEntity<String> hapus(@PathVariable("id") Integer id, @RequestHeader("Authorization") String authorization) throws Exception {
		String[] auth = super.authUser(authorization);
		try {
			diskonService.hapusDiskon(id, auth[0], auth[1]);
		} catch (Exception e) {
			return new ResponseEntity<>("Gagal Hapus Diskon", HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<>("Berhasil Hapus Diskon", HttpStatus.OK);
	}
}
