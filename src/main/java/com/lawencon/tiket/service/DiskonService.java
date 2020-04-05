package com.lawencon.tiket.service;

import java.util.List;

import com.lawencon.tiket.model.Diskon;

public interface DiskonService {
	abstract String tambahDiskon(Diskon diskon, String username, String password) throws Exception;
	abstract List<Diskon> tampilDiskon(String username, String password) throws Exception;
	abstract String ubahDiskon(Diskon diskon, String username, String password) throws Exception;
	abstract String hapusDiskon(Integer id, String username, String password) throws Exception;
}
