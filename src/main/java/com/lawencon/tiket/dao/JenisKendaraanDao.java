package com.lawencon.tiket.dao;

import java.util.List;

import com.lawencon.tiket.model.JenisKendaraan;


public interface JenisKendaraanDao {
	abstract void tambahJenisKendaraan(JenisKendaraan jenisKendaraan) throws Exception;
	abstract List<JenisKendaraan> tampilJenisKendaraan() throws Exception;
	abstract void ubahJenisKendaraan(JenisKendaraan jenisKendaraan) throws Exception;
	abstract void hapusJenisKendaraan(Integer id) throws Exception;
}
