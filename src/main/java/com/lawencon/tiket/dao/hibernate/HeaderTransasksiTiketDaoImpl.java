package com.lawencon.tiket.dao.hibernate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.lawencon.tiket.dao.CustomerDao;
import com.lawencon.tiket.dao.HeaderTransasksiTiketDao;
import com.lawencon.tiket.model.HeaderTransasksiTiket;

@Repository("header_hibernate")
public class HeaderTransasksiTiketDaoImpl extends BaseHibernate implements HeaderTransasksiTiketDao {

	@Autowired
	@Qualifier("customer_jpa")
	CustomerDao customerDao;
	
	@Override
	public void tambahTransaksiHeader(String username, String password)
			throws Exception {
		HeaderTransasksiTiket h = new HeaderTransasksiTiket();
		h.setCustomer(customerDao.cekCustomer(username, password));
		em.persist(h);
	}

}
