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
import com.lawencon.tiket.model.JenisKendaraan;
import com.lawencon.tiket.service.JenisKendaraanService;

@RestController
public class JenisKendaraanController  extends BaseController{
	
	@Autowired
	JenisKendaraanService jenisKendaraanService;
	
	@PostMapping("/jeniskendaraan")
	public ResponseEntity<String> tambah(@RequestBody String content, @RequestHeader("Authorization") String authorization) throws Exception {
		JenisKendaraan jk = new JenisKendaraan();
		String[] auth = super.authUser(authorization);
		try {
			jk = new ObjectMapper().readValue(content, JenisKendaraan.class);
			jenisKendaraanService.tambahJenisKendaraan(jk, auth[0], auth[1]);
		} catch (Exception e) {
			return new ResponseEntity<>("Gagal Tambah Jenis Kendaraan",HttpStatus.BAD_GATEWAY);
		}
		return new ResponseEntity<>(jenisKendaraanService.tambahJenisKendaraan(jk, auth[0], auth[1]), HttpStatus.ACCEPTED);
	}	

	@GetMapping("/jeniskendaraan")
	public ResponseEntity<?> tampil(@RequestHeader("Authorization") String authorization) {
		List<JenisKendaraan> list = new ArrayList<>();
		String[] auth = super.authUser(authorization);
		try {
			list = jenisKendaraanService.tampilJenisKendaraan(auth[0], auth[1]);
		} catch (Exception e) {
			return new ResponseEntity<>("Gagal Menampilkan List Jenis Kendaraan", HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<>(list, HttpStatus.OK);
	}

	@PutMapping("/jeniskendaraan")
	public ResponseEntity<String> ubah(@RequestBody String content, @RequestHeader("Authorization") String authorization) throws Exception {
		JenisKendaraan jk = new JenisKendaraan();
		String[] auth = super.authUser(authorization);
		try {
			jk = new ObjectMapper().readValue(content, JenisKendaraan.class);
			jenisKendaraanService.ubahJenisKendaraan(jk, auth[0], auth[1]);
		} catch (Exception e) {
			return new ResponseEntity<>("Gagal Update Jenis Kendaraan", HttpStatus.BAD_GATEWAY);
		}
		return new ResponseEntity<>(jenisKendaraanService.ubahJenisKendaraan(jk, auth[0], auth[1]), HttpStatus.ACCEPTED);
	}

	@DeleteMapping("/jeniskendaraan/{id}")
	public ResponseEntity<String> hapus(@PathVariable("id") Integer id, @RequestHeader("Authorization") String authorization) throws Exception {
		String[] auth = super.authUser(authorization);
		try {
			jenisKendaraanService.hapusJenisKendaraan(id, auth[0], auth[1]);
		} catch (Exception e) {
			return new ResponseEntity<>("Gagal Hapus Jenis Kendaraan", HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<>("Berhasil Hapus Jenis Kendaraan", HttpStatus.OK);
	}
}
