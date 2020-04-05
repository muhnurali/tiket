package com.lawencon.tiket.service;

import java.util.List;

import com.lawencon.tiket.model.JenisKendaraan;

public interface JenisKendaraanService {
	abstract String tambahJenisKendaraan(JenisKendaraan jenisKendaraan, String username, String password) throws Exception;
	abstract List<JenisKendaraan> tampilJenisKendaraan(String username, String password) throws Exception;
	abstract String ubahJenisKendaraan(JenisKendaraan jenisKendaraan, String username, String password) throws Exception;
	abstract String hapusJenisKendaraan(Integer id, String username, String password) throws Exception;
}
