package com.lawencon.tiket.service;

import com.lawencon.tiket.model.HeaderTransasksiTiket;

public interface HeaderTransasksiTiketService {
	abstract HeaderTransasksiTiket tambahTransaksiHeader(HeaderTransasksiTiket header) throws Exception;
	abstract void totalTransaksiHeader(HeaderTransasksiTiket header) throws Exception;
}
