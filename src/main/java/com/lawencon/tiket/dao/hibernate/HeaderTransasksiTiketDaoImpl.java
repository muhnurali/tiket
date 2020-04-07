package com.lawencon.tiket.dao.hibernate;


import javax.persistence.Query;

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

	@Override
	public HeaderTransasksiTiket totalTransaksiHeader(HeaderTransasksiTiket header) throws Exception {
		//keluarin dulu
		Query q = em.createQuery("update HeaderTransasksiTiket set jumlahBayar = ("
				+ "select sum(jk.harga) from DetailTransaksiTiket dt " + 
				"join JenisKendaraan dt.jenisKendaraan jk " + 
				"where dt.headerTransaksiTiker = :param) where Id = :paramLagi");
		q.setParameter("param", header);
		q.setParameter("paramLagi", header.getId());
		return (HeaderTransasksiTiket) q.getResultList();
	}

}
