package com.lawencon.tiket.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;
import com.lawencon.tiket.model.HeaderDetail;
import com.lawencon.tiket.service.TransaksiService;

@SuppressWarnings("rawtypes")
@RestController
public class TransasksiController extends BaseController{
	
	@Autowired
	TransaksiService ts;
	
	@SuppressWarnings("unchecked")
	@PostMapping("/transaksi")
	public ResponseEntity<?> tambahTransaksi(@RequestBody String content,
			@RequestHeader("Authorization") String authorization) throws Exception {
		HeaderDetail hd = new HeaderDetail();
		String[] auth = super.authUser(authorization);
		try {
			hd = (HeaderDetail) super.readValue(content, HeaderDetail.class);
			ts.simpanTransaksi(hd, auth[0], auth[1]);
			return new ResponseEntity<>(hd, HttpStatus.ACCEPTED);
		} catch (Exception e) {
			return new ResponseEntity<>("Gagal Tambah Transaksi",HttpStatus.BAD_GATEWAY);
		}

	}	
	
}
