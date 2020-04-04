package com.lawencon.tiket.service;

import com.lawencon.tiket.model.HeaderTransasksiTiket;

public interface HeaderTransasksiTiketService {
	abstract void tambahTransaksiHeader(String username, String password) throws Exception;
	abstract HeaderTransasksiTiket tampilkan();
}
