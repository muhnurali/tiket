package com.lawencon.tiket.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lawencon.tiket.dao.CustomerDao;
import com.lawencon.tiket.dao.DetailTransaksiTiketDao;
import com.lawencon.tiket.dao.HeaderTransasksiTiketDao;
import com.lawencon.tiket.model.DetailTransaksiTiket;
import com.lawencon.tiket.model.HeaderDetail;
import com.lawencon.tiket.model.HeaderTransasksiTiket;

@Service
@Transactional
public class DetailTransaksiTiketServiceImpl implements DetailTransaksiTiketService {

	@Autowired
	DetailTransaksiTiketDao detail;
	
	@Autowired
	HeaderTransasksiTiketDao header;
	
	@Autowired
	CustomerDao customerDao;
	
	@Override
	public String tambahTransaksiDetail(List<HeaderDetail> listHeaderDetail, String username, String password)
			throws Exception {
		HeaderTransasksiTiket header = new HeaderTransasksiTiket();
		header.setCustomer(customerDao.cekCustomer(username, password));
		listHeaderDetail.forEach(x->{
			x.getDetail().forEach(y->{
				DetailTransaksiTiket detail = y;
				detail.setHeaderTransaksiTiker(header);
				try {
					this.detail.tambahTransaksiDetail(detail, username, password);
				} catch (Exception e) {
					e.printStackTrace();
				}
			});
		});	
		return "Berhasil";
	}

	@Override
	public List<DetailTransaksiTiket> tampil() {
		return detail.tampil();
	}

}
