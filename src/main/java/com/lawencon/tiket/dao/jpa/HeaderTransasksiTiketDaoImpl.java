package com.lawencon.tiket.dao.jpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.lawencon.tiket.dao.HeaderTransasksiTiketDao;
import com.lawencon.tiket.model.HeaderTransasksiTiket;

@Repository("header_jpa")
public class HeaderTransasksiTiketDaoImpl implements HeaderTransasksiTiketDao {

	@Autowired
	HeaderTransaksiTiketRevo headerRevo;
	
	@Override
	public HeaderTransasksiTiket tambahTransaksiHeader(HeaderTransasksiTiket header) throws Exception {
		return headerRevo.save(header);
	}

	@Override
	public HeaderTransasksiTiket totalTransaksiHeader(HeaderTransasksiTiket header) throws Exception {
		return headerRevo.save(header);
	}

	

}
