package com.lawencon.tiket.dao.hibernate;

import java.util.List;
import javax.persistence.Query;
import org.springframework.stereotype.Repository;
import com.lawencon.tiket.dao.DiskonDao;
import com.lawencon.tiket.model.Diskon;

@Repository("diskon_hibernate")
public class DiskonDaoImpl extends BaseHibernate implements DiskonDao{

	@Override
	public void tambahDiskon(Diskon diskon) throws Exception {
		em.persist(diskon);		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Diskon> tampilDiskon() throws Exception {
		Query q = em.createQuery("from Diskon");
		return q.getResultList();
	}

	@Override
	public void ubahDiskon(Diskon diskon) throws Exception {
		em.merge(diskon);
	}

	@Override
	public void hapusDiskon(Integer id) throws Exception {
		Query q = em.createQuery(" from Diskon where id = :idParam");
		q.setParameter("idParam", id);
		Diskon temp = new Diskon();
		temp = (Diskon) q.getSingleResult();
		em.remove(temp);		
	}

}
