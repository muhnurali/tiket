package com.lawencon.tiket.dao.hibernate;

import org.springframework.stereotype.Repository;
import com.lawencon.tiket.dao.HeaderTransasksiTiketDao;
import com.lawencon.tiket.model.HeaderTransasksiTiket;

@Repository("header_hibernate")
public class HeaderTransasksiTiketDaoImpl extends BaseHibernate implements HeaderTransasksiTiketDao {

	@Override
	public HeaderTransasksiTiket tambahTransaksiHeader(HeaderTransasksiTiket header) throws Exception {
		em.persist(header);
		return header;
	}

}
