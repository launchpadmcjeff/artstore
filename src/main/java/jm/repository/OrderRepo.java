package jm.repository;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.enterprise.event.Event;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import jm.model.Order;

@Stateless
public class OrderRepo {
	@PersistenceContext
	EntityManager em;
	
	
	@Inject
	Event<Order> webOrderEvent;
	
	public OrderRepo() {
		
	}

	public List<Order> getOrders() {
		return new ArrayList<>();
	}

	public void newOrder(Order order) {
//		webOrderEvent.fire(order);
		
	}
}
