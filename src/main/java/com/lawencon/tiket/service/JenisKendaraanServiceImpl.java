package com.lawencon.tiket.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lawencon.tiket.dao.JenisKendaraanDao;
import com.lawencon.tiket.model.JenisKendaraan;

@Service
@Transactional
public class JenisKendaraanServiceImpl implements JenisKendaraanService {

	@Autowired
	CustomerService customerService;
	
	@Autowired
	@Qualifier("jeniskendaraan_hibernate")
	JenisKendaraanDao jenisKendaraanDao;

	@Override
	public String tambahJenisKendaraan(JenisKendaraan jenisKendaraan, String username, String password)
			throws Exception {
		customerService.cekCustomer(username, password);
		jenisKendaraanDao.tambahJenisKendaraan(jenisKendaraan);
		return "Berhasil Tambah Jenis Kendaraan";
	}

	@Override
	public List<JenisKendaraan> tampilJenisKendaraan(String username, String password) throws Exception {
		customerService.cekCustomer(username, password);
		return jenisKendaraanDao.tampilJenisKendaraan();
	}

	@Override
	public String ubahJenisKendaraan(JenisKendaraan jenisKendaraan, String username, String password) throws Exception {
		customerService.cekCustomer(username, password);
		jenisKendaraanDao.ubahJenisKendaraan(jenisKendaraan);
		return "Berhasil Ubah Jenis Kendaraan";
	}

	@Override
	public String hapusJenisKendaraan(Integer id, String username, String password) throws Exception {
		customerService.cekCustomer(username, password);
		jenisKendaraanDao.hapusJenisKendaraan(id);
		return "Berhasil Hapus Jenis Kendaraan";
	}
	
	
	
}
