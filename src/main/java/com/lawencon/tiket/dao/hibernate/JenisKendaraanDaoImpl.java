package com.lawencon.tiket.dao.hibernate;

import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.lawencon.tiket.dao.JenisKendaraanDao;
import com.lawencon.tiket.model.JenisKendaraan;

@Repository("jeniskendaraan_hibernate")
public class JenisKendaraanDaoImpl extends BaseHibernate implements JenisKendaraanDao {

	@Override
	public void tambahJenisKendaraan(JenisKendaraan jenisKendaraan) throws Exception {
		em.persist(jenisKendaraan);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<JenisKendaraan> tampilJenisKendaraan() throws Exception {
		Query q = em.createQuery(" from JenisKendaraan");
		return q.getResultList();
	}

	@Override
	public void ubahJenisKendaraan(JenisKendaraan jenisKendaraan) throws Exception {
		em.merge(jenisKendaraan);
	}

	@Override
	public void hapusJenisKendaraan(Integer id) throws Exception {
		Query q = em.createQuery(" from JenisKendaraan where id = :idParam");
		q.setParameter("idParam", id);
		JenisKendaraan temp = new JenisKendaraan();
		temp = (JenisKendaraan) q.getSingleResult();
		em.remove(temp);		
	}

}
