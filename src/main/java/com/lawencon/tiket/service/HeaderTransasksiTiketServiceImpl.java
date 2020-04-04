package com.lawencon.tiket.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.lawencon.tiket.dao.HeaderTransasksiTiketDao;
import com.lawencon.tiket.model.HeaderTransasksiTiket;

@Service
@Transactional
public class HeaderTransasksiTiketServiceImpl implements HeaderTransasksiTiketService {

	@Autowired
	@Qualifier("header_hibernate")
	HeaderTransasksiTiketDao headerTransasksiTiketDao;

	@Override
	public void tambahTransaksiHeader(String username, String password)
			throws Exception {
		headerTransasksiTiketDao.tambahTransaksiHeader(username, password);
	}

	@Override
	public HeaderTransasksiTiket tampilkan() {
		// TODO Auto-generated method stub
		return null;
	}

}