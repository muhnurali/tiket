package com.lawencon.tiket.dao;

import java.util.List;

import com.lawencon.tiket.model.Diskon;

public interface DiskonDao {
	abstract void tambahDiskon(Diskon diskon) throws Exception;
	abstract List<Diskon> tampilDiskon() throws Exception;
	abstract void ubahDiskon(Diskon diskon) throws Exception;
	abstract void hapusDiskon(Integer id) throws Exception;
}
