package com.lawencon.tiket.dao.jpa;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.lawencon.tiket.dao.JenisKendaraanDao;
import com.lawencon.tiket.model.JenisKendaraan;

@Repository("jeniskendaraan_jpa")
public class JenisKendaraanDaoImpl implements JenisKendaraanDao{

	@Autowired
	JenisKendaraanRevo jenisKendaraanRevo;
	
	@Override
	public void tambahJenisKendaraan(JenisKendaraan jenisKendaraan) throws Exception {
		jenisKendaraanRevo.save(jenisKendaraan);
	}

	@Override
	public List<JenisKendaraan> tampilJenisKendaraan() throws Exception {
		return jenisKendaraanRevo.findAll();
	}

	@Override
	public void ubahJenisKendaraan(JenisKendaraan jenisKendaraan) throws Exception {
		jenisKendaraanRevo.save(jenisKendaraan);
	}

	@Override
	public void hapusJenisKendaraan(Integer id) throws Exception {
		jenisKendaraanRevo.deleteById(id);
	}

}
