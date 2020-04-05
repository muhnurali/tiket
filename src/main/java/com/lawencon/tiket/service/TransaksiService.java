package com.lawencon.tiket.service;

import com.lawencon.tiket.model.HeaderDetail;

public interface TransaksiService {
	abstract HeaderDetail simpanTransaksi(HeaderDetail headerDetail, String username, String password) throws Exception;
}
