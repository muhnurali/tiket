package com.lawencon.tiket.dao.hibernate;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class CustomRevo {
	@PersistenceContext
	protected EntityManager em;
}
