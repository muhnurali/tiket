package com.lawencon.tiket.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.lawencon.tiket.dao.DiskonDao;
import com.lawencon.tiket.model.Diskon;

@Service
@Transactional
public class DiskonServiceImpl implements DiskonService {

	@Autowired
	@Qualifier("diskon_hibernate")
	DiskonDao diskonDao;
	
	@Autowired
	CustomerService customerService;
	
	@Override
	public String tambahDiskon(Diskon diskon, String username, String password) throws Exception {
		customerService.cekCustomer(username, password);
		diskonDao.tambahDiskon(diskon);
		return "Berhasil Tambah Diskon";
	}

	@Override
	public List<Diskon> tampilDiskon(String username, String password) throws Exception {
		customerService.cekCustomer(username, password);
		return diskonDao.tampilDiskon();
	}

	@Override
	public String ubahDiskon(Diskon diskon, String username, String password) throws Exception {
		customerService.cekCustomer(username, password);
		diskonDao.ubahDiskon(diskon);
		return "Berhasil Ubah Diskon";
	}

	@Override
	public String hapusDiskon(Integer id, String username, String password) throws Exception {
		customerService.cekCustomer(username, password);
		diskonDao.hapusDiskon(id);
		return "Berhasil Hapus Diskon";
	}

}
