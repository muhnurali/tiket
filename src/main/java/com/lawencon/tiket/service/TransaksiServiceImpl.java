package com.lawencon.tiket.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lawencon.tiket.model.DetailTransaksiTiket;
import com.lawencon.tiket.model.HeaderDetail;
import com.lawencon.tiket.model.HeaderTransasksiTiket;

@Service
@Transactional
public class TransaksiServiceImpl implements TransaksiService{

	@Autowired
	DetailTransaksiTiketService detail;
	
	@Autowired
	HeaderTransasksiTiketService header;
	
	@Autowired
	CustomerService cs;
	
	@Override
	public void simpanTransaksi(HeaderDetail headerDetail, String username, String password) throws Exception {
		cs.cekCustomer(username, password);
		HeaderTransasksiTiket headerTiket = header.tambahTransaksiHeader(headerDetail.getHeader());
		headerDetail.getDetail().forEach(x->{
			DetailTransaksiTiket dt = x;
			dt.setHeaderTransaksiTiker(headerTiket);
			try {
				detail.tambahTransaksiDetail(dt);
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
	}


}
