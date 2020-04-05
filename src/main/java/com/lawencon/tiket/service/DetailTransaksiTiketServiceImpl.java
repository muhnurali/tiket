package com.lawencon.tiket.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.lawencon.tiket.dao.DetailTransaksiTiketDao;
import com.lawencon.tiket.model.DetailTransaksiTiket;

@Service
@Transactional
public class DetailTransaksiTiketServiceImpl implements DetailTransaksiTiketService {

	@Autowired
	@Qualifier("detail_hibernate")
	DetailTransaksiTiketDao detailTransaksi;
	
	@Override
	public String tambahTransaksiDetail(DetailTransaksiTiket detail) throws Exception {
		detailTransaksi.tambahTransaksiDetail(detail);
		return "Behasil";
	}
	

}
