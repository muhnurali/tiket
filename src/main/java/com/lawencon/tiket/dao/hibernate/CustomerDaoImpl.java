	package com.lawencon.tiket.dao.hibernate;

import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.lawencon.tiket.dao.CustomerDao;
import com.lawencon.tiket.model.Customer;

@Repository("customer_hibernate")
public class CustomerDaoImpl extends CustomRevo implements CustomerDao {


	@SuppressWarnings("unchecked")
	@Override
	public List<Customer> tampilCustomer() throws Exception {
		Query q = em.createQuery("from Customer");
		return q.getResultList();
	}

	@Override
	public void ubahCustomer(Customer customer) throws Exception {
		em.merge(customer);
	}

	@Override
	public void hapusCustomer(Customer customer) throws Exception {
		Customer temp = new Customer();
		temp = getById(customer.getId());
		em.remove(temp);
	}

	@Override
	public void tambahCustomer(Customer customer) throws Exception {
		em.persist(customer);
	}

	@Override
	public Customer getById(Integer id) throws Exception {
		Query q = em.createQuery(" from Customer where id = :idParam");
		q.setParameter("idParam", id);
		return (Customer) q.getResultList();
	}

	@Override
	public Customer cekCustomer(String username, String password) throws Exception {
		Query q = em.createQuery("from Customer where username = :username and password = :password");
		q.setParameter("username", username);
		q.setParameter("password", password);
		return (Customer)q.getResultList();
	}

}
