package com.lawencon.tiket.service;

import java.util.List;

import com.lawencon.tiket.model.DetailTransaksiTiket;
import com.lawencon.tiket.model.HeaderDetail;

public interface DetailTransaksiTiketService {
	abstract String tambahTransaksiDetail(List<HeaderDetail> listHeaderDetail, String username, String password) throws Exception;
	
	abstract List<DetailTransaksiTiket> tampil();
}
