package com.lawencon.tiket.dao.jpa;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.lawencon.tiket.dao.DetailTransaksiTiketDao;
import com.lawencon.tiket.model.DetailTransaksiTiket;

@Repository("detail_jpa")
public class DetailTransaksiTiketDaoImpl implements DetailTransaksiTiketDao {

	@Autowired
	DetailTransaksiTiketRevo detailRevo;
	
	@Override
	public void tambahTransaksiDetail(DetailTransaksiTiket detailTransaksi) throws Exception {
		detailRevo.save(detailTransaksi);
	}

	@Override
	public List<DetailTransaksiTiket> tampil() {
		return detailRevo.findAll();
	}

	

}
