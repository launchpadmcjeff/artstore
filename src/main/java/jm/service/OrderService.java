package jm.service;

import javax.ejb.Stateless;
import javax.enterprise.event.Observes;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import jm.model.WebOrder;

@Stateless
public class OrderService {
	@PersistenceContext
	private EntityManager em;

	public void saveOrder(@Observes WebOrder webOrder) {
		em.persist(webOrder);
	}
	
	
}
