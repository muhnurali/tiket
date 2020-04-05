package com.lawencon.tiket.dao.jpa;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.lawencon.tiket.dao.DiskonDao;
import com.lawencon.tiket.model.Diskon;

@Repository("diskon_jpa")
public class DiskonDaoImpl implements DiskonDao {
	
	@Autowired
	DiskonRevo diskonRevo;
	
	@Override
	public void tambahDiskon(Diskon diskon) throws Exception {
		diskonRevo.save(diskon);		
	}

	@Override
	public List<Diskon> tampilDiskon() throws Exception {
		return diskonRevo.findAll();
	}

	@Override
	public void ubahDiskon(Diskon diskon) throws Exception {
		diskonRevo.save(diskon);
	}

	@Override
	public void hapusDiskon(Integer id) throws Exception {
		diskonRevo.deleteById(id);		
	}

}
