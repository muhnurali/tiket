package com.lawencon.tiket.dao;

import java.util.List;

import com.lawencon.tiket.model.DetailTransaksiTiket;

public interface DetailTransaksiTiketDao {
	abstract void tambahTransaksiDetail(DetailTransaksiTiket detailTransaksi) throws Exception;
	abstract List<DetailTransaksiTiket> tampil();
}
