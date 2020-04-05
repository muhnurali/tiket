package com.lawencon.tiket.dao.hibernate;

import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.lawencon.tiket.dao.DetailTransaksiTiketDao;
import com.lawencon.tiket.model.DetailTransaksiTiket;

@Repository("detail_hibernate")
public class DetailTransaksiTiketDaoImpl extends BaseHibernate implements DetailTransaksiTiketDao {

	@Override
	public void tambahTransaksiDetail(DetailTransaksiTiket detailTransaksi, String username, String password)
			throws Exception {
		em.persist(detailTransaksi);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<DetailTransaksiTiket> tampil() {
		Query q = em.createQuery("from DetailTransaksiTiket");
		return q.getResultList();
	}

}
