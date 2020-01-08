package jm.service;

import javax.ejb.Stateless;
import javax.enterprise.event.Observes;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.jboss.logging.Logger;

import jm.model.Order;

@Stateless
public class OrderService {
	Logger LOGGER = Logger.getLogger(OrderService.class);
	
	@PersistenceContext
	private EntityManager em;

	public void saveOrder(@Observes Order webOrder) {
		LOGGER.info(webOrder);
		em.persist(webOrder);
	}
	
	
}
