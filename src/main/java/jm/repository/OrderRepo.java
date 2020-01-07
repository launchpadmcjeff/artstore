package jm.repository;

import java.util.List;

import javax.ejb.Stateless;
import javax.enterprise.event.Event;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.jboss.logging.Logger;

import jm.model.Order;

@Stateless
public class OrderRepo {
	private static final Logger LOGGER = Logger.getLogger(OrderRepo.class);

	@PersistenceContext
	EntityManager em;

	@Inject
	Event<Order> webOrderEvent;

	public OrderRepo() {

	}

	public List<Order> getOrders() {
		return em.createQuery("select o from Order o", Order.class).getResultList();
	}

	public void newOrder(Order order) {
		webOrderEvent.fire(order);
		LOGGER.info(order);
	}
}
