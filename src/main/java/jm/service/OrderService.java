package jm.service;

import javax.ejb.Stateless;
import javax.enterprise.event.Observes;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import jm.model.Order;

@Stateless
public class OrderService {
	@PersistenceContext
	private EntityManager em;

	public void saveOrder(@Observes Order webOrder) {
		em.persist(webOrder);
	}
	
	
}
